package game.ui;

import game.user.User;
import game.util.ConsoleUtil;
import game.util.VerificationCodeUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class UserSystem {
    private final ArrayList<User> userList = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    /**
     * メインメニューを表示して処理を分岐
     */
    public User start() {
        final String menuLogin = "1";
        final String menuRegister = "2";
        final String menuExit = "3";

        while (true) {
            ConsoleUtil.printLine();
            String title = "🎮 文字格闘ゲームへようこそ 🎮";
            ConsoleUtil.printCentered(title);
            ConsoleUtil.printLine();

            System.out.println("\n=== ユーザーシステム ===");
            System.out.println("1: ログイン");
            System.out.println("2: 新規登録");
            System.out.println("3: 終了");
            System.out.println("選択してください：");

            String choice = ConsoleUtil.normalizeInput(sc.next());
            sc.nextLine();

            switch (choice) {
                case menuLogin -> {
                    User loginUser = login();
                    if (loginUser != null) {
                        return loginUser; // ログイン成功 → ユーザーオブジェクトを返して抜ける
                    }
                }
                case menuRegister -> register();
                case menuExit -> {
                    return null;
                }
                default -> System.out.println("無効な入力です");
            }
        }
    }

    /**
     * ログイン機能
     */
    private User login() {
        System.out.println("\n--- 新規ユーザー登録 ---");
        System.out.println("ユーザー名を入力：");
        String username = sc.nextLine();

        // 未登録チェック
        User user = findUserByUsername(username);
        if (user == null) {
            System.out.println("ユーザー名未登録、先に登録してください\n");
            return null;
        }

        // アカウントロックチェック
        if (!user.isState()) {
            System.out.printf(
                    "ユーザー%sはロックされています。窓口までお問い合わせください：XXX-XXXX%n", username);
            return null;
        }


        for (int i = 0; i < 3; i++) {
            while (true) {
                // 認証コード生成と表示
                String code = VerificationCodeUtil.generateCode();
                System.out.println("認証コード：" + code);
                System.out.println("認証コードを入力：");
                String inputCode = sc.nextLine();
                // 認証コードチェック（大文字小文字区別なし）
                boolean isCodeMatch = code.equalsIgnoreCase(inputCode);
                if (!isCodeMatch) {
                    System.out.println("認証コードが間違っています。");
                    continue;
                }
                break;
            }

            System.out.println("パスワードを入力：");
            String inputPwd = sc.nextLine();
            boolean isPasswordMatch = inputPwd.equals(user.getPassword());
            if (!isPasswordMatch) {
                user.setRemainCount(user.getRemainCount() - 1);
                int remainCount = user.getRemainCount();

                if (remainCount > 0) {
                    System.out.println("パスワードが間違っています。残り試行回数：" + remainCount);
                } else {
                    // 3回失敗→アカウントロック
                    user.setState(false);
                    System.out.println("連続3回失敗したため、アカウントをロックしました");
                    return null;
                }
            } else break;

        }
        System.out.println("ログインに成功しました\n");
        user.setRemainCount(User.MAX_LOGIN_ATTEMPTS);
        return user;
    }

    /**
     * ユーザー登録機能
     */
    private void register() {
        System.out.println("\n--- 新規ユーザー登録 ---");

        // ユーザー名入力とバリデーション
        String username;
        while (true) {
            System.out.println("ユーザー名を入力：");
            username = sc.nextLine();
            // バリデーションチェック
            String usernameError = checkUsername(username);
            if (usernameError != null) {
                System.out.println(usernameError);
                continue;
            }

            // 重複チェック
            User user = findUserByUsername(username);
            if (user != null) {
                System.out.println("このユーザー名は既に使用されています");
                continue;
            }
            break;
        }

        // パスワード2回入力と一致確認
        String pwd1;
        while (true) {
            System.out.println("パスワードを入力：");
            pwd1 = sc.nextLine();
            System.out.println("パスワードを再入力：");
            String pwd2 = sc.nextLine();


            if (!pwd1.equals(pwd2)) {
                System.out.println("2回のパスワードが一致しません");
                continue;
            }
            // パスワードバリデーション
            String pwdError = checkPassword(pwd1);
            if (pwdError != null) {
                System.out.println(pwdError);
                continue;
            }
            break;
        }
        createUserAccount(userList, username, pwd1);
    }

    /**
     * ユーザー名のバリデーション
     *
     * @return エラーメッセージ（正常ならnull）
     */
    private static String checkUsername(String username) {
        int len = username.length();
        if (len < 3 || len > 16) {
            return "ユーザー名は3～16桁にしてください";
        }

        boolean hasAlphabet = false;
        for (int i = 0; i < len; i++) {
            char c = username.charAt(i);
            boolean isAlphabet = (c >= 'a' && c <= 'z')
                    || (c >= 'A' && c <= 'Z');
            boolean isDigit = (c >= '0' && c <= '9');
            // 英数字のみか
            if (!(isAlphabet || isDigit)) {
                return "ユーザー名は英字と数字のみ使用できます";
            }
            if (!hasAlphabet && isAlphabet) {
                hasAlphabet = true;
            }
        }
        // 純数字は不可
        if (!hasAlphabet) {
            return "ユーザー名を数字のみにすることはできません";
        }
        return null;
    }

    /**
     * パスワードのバリデーション
     *
     * @return エラーメッセージ（正常ならnull）
     */
    private static String checkPassword(String password) {
        int len = password.length();
        if (len < 3 || len > 16) {
            return "パスワードは3～16桁にしてください";
        }
        boolean hasAlphabet = false;
        boolean hasDigit = false;
        for (int i = 0; i < len; i++) {
            char c = password.charAt(i);
            boolean isAlphabet = (c >= 'a' && c <= 'z')
                    || (c >= 'A' && c <= 'Z');
            boolean isDigit = (c >= '0' && c <= '9');

            if (!(isAlphabet || isDigit)) {
                return "パスワードは英字と数字のみ使用できます";
            }
            // アルファベットと数字、両方揃っていない時だけ実行
            if (!(hasAlphabet && hasDigit)) {
                if (!hasAlphabet && isAlphabet) {
                    hasAlphabet = true;
                }
                if (!hasDigit && isDigit) {
                    hasDigit = true;
                }
            }
        }
        // アルファベットと数字、両方揃っていない
        if (!(hasAlphabet && hasDigit)) {
            return "パスワードには英字と数字を1つ以上含めてください";
        }

        return null;
    }

    /**
     * アカウントを作成する
     *
     * @param userList ユーザーを保存するリスト
     * @param username ユーザー名
     * @param password パスワード
     */
    private static void createUserAccount(ArrayList<User> userList, String username, String password) {
        User user = new User(username, password);
        userList.add(user);
        System.out.println("\n登録が完了しました");
        System.out.println(user);
    }

    /**
     * ユーザー名からユーザーを検索
     *
     * @return 見つかったUserオブジェクト、存在しない場合はnull
     */
    private User findUserByUsername(String username) {
        for (User user : userList) {
            if (username.equals(user.getUsername()))
                return user;
        }
        return null;
    }
}