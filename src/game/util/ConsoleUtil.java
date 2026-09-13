package game.util;

public final class ConsoleUtil {
    // 画面全体の基準幅
    public static final int SCREEN_WIDTH = 40;

    private ConsoleUtil() {
    }

    /**
     * 文字列の実際の表示幅を計算
     * 全角文字（日本語・中国語・全角記号）：2幅
     * 半角文字（英数字・半角記号）：1幅
     */
    private static int getDisplayWidth(String str) {
        int width = 0;
        for (char c : str.toCharArray()) {
            // CJK漢字・ひらがな・カタカナ・全角記号の範囲
            if ((c >= '\u2E80' && c <= '\uFE4F') || (c >= '\uFF00' && c <= '\uFFEF')) {
                width += 2;
            } else {
                width += 1;
            }
        }
        return width;
    }

    /**
     * 指定した総幅で文字列を中央揃え出力
     *
     * @param content 表示したい文字列
     */
    public static void printCentered(String content) {
        int contentWidth = getDisplayWidth(content);
        int padding = SCREEN_WIDTH - contentWidth;

        // 内容が幅を超える場合はそのまま出力
        if (padding <= 0) {
            System.out.println(content);
            return;
        }

        int rightPad = padding / 2;
        int leftPad = padding - rightPad;
        System.out.println(" ".repeat(leftPad) + content + " ".repeat(rightPad));
    }

    /**
     * 基準幅の区切り線を出力
     */
    public static void printLine() {
        System.out.println("=".repeat(SCREEN_WIDTH));
    }

    /**
     * 入力文字列を正規化
     * 前後空白除去 + 全角文字→半角文字 + 小文字統一
     * 数字・アルファベット・記号すべて対応
     */
    public static String normalizeInput(String input) {
        if (input == null || input.isBlank()) {
            return "";
        }

        char[] chars = input.trim().toCharArray();

        for (int i = 0; i < chars.length; i++) {
            // 全角可視文字（FF01～FF5E）を半角に変換
            // 数字・大文字・小文字アルファベット・一般記号すべてを含む
            if (chars[i] >= '\uFF01' && chars[i] <= '\uFF5E') {
                chars[i] = (char) (chars[i] - 0xFEE0);
            }
        }

        // 小文字に統一（大文字で統一する場合は toUpperCase() に変更）
        return new String(chars).toUpperCase();
    }
}
