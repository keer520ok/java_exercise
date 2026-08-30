package practice.string;

import java.util.Random;

/**
 * 4文字アルファベット+1桁数字の認証コードランダム生成
 */
public class Ex09 {
    // 乱数生成インスタンス
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        // 10回生成して動作確認
        for (int i = 0; i < 10; i++) {
            System.out.println(generateCode());
        }
    }

    /**
     * 長さ5、アルファベット4文字 + 数字1文字の認証コードを生成する
     * 数字は任意の位置に出現する
     *
     * @return 生成した認証コード
     */
    private static String generateCode() {
        StringBuilder sb = new StringBuilder(5);

        // アルファベット4文字を生成（大文字小文字ランダム）
        for (int i = 0; i < 4; i++) {
            // trueなら大文字、falseなら小文字
            char baseChar = RANDOM.nextBoolean() ? 'A' : 'a';
            char c = (char) (baseChar + RANDOM.nextInt(26));
            sb.append(c);
        }

        // ランダムな位置に数字を1つ挿入
        int digitPosition = RANDOM.nextInt(5);
        int digit = RANDOM.nextInt(10);
        sb.insert(digitPosition, digit);

        return sb.toString();
    }
}
