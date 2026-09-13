package game.util;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 認証コード生成ユーティリティ
 */
public final class VerificationCodeUtil {
    private VerificationCodeUtil() {
    }

    /**
     * 認証コードをランダム生成する
     * * 仕様：長さ5、英字4文字+数字1文字、数字は任意の位置
     *
     * @return 生成された5桁認証コード
     */
    public static String generateCode() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        StringBuilder sb = new StringBuilder(5);
        // ランダムな位置に数字を1つ挿入
        int digitIndex = random.nextInt(5);
        // アルファベット4文字を生成（大文字小文字ランダム）
        for (int i = 0; i < 5; i++) {
            if (i == digitIndex) {
                int digit = random.nextInt(10);
                sb.append(digit);

            } else {
                // trueなら大文字、falseなら小文字
                char baseChar = random.nextBoolean() ? 'A' : 'a';
                char c = (char) (baseChar + random.nextInt(26));
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

