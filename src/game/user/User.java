package game.user;

import java.util.Random;

public class User {
    // ログイン失敗可能最大回数：この回数分失敗したらアカウントをロックする
    public static final int MAX_LOGIN_ATTEMPTS = 3;

    // ユーザーID：自動生成 game_+5桁数字
    private final String id;
    // ユーザー名：唯一、3～16桁、英数字のみ、純数字不可
    private String username;
    // パスワード：3～16桁、英数字のみ、純数字不可、純英文字不可
    private String password;
    // アカウント状態：true=使用可、false=ロック済
    private boolean state;
    // ログイン失敗可能残り回数
    private int remainCount;

    private static final Random RANDOM = new Random();

    public User(String username, String password) {
        this.id = setID();
        this.username = username;
        this.password = password;
        this.state = true;
        this.remainCount = MAX_LOGIN_ATTEMPTS;
    }

    private static String setID() {
        StringBuilder sb = new StringBuilder("game_");
        for (int i = 0; i < 5; i++) {
            int n;
            if (i == 4) {
                n = RANDOM.nextInt(9) + 1;
            } else {
                n = RANDOM.nextInt(10);
            }
            sb.append(n);
        }
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getRemainCount() {
        return remainCount;
    }

    public void setRemainCount(int remainCount) {
        this.remainCount = remainCount;
    }

    @Override
    public String toString() {
        return "ID： " + id + "\nユーザー名： " + username + "\nパスワード：" + password;
    }
}
