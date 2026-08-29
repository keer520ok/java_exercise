package practice.string;

public class Ex04 {
    public static void main(String[] args) {

        System.out.println(subtract("1000", "1"));      // 999
        System.out.println(subtract("2", "999"));        // -997
        System.out.println(subtract("1234", "1234"));    // 0
        System.out.println(subtract("00123", "045"));    // 78
    }

    /**
     * 2つの非負整数文字列の減算結果を返す
     */
    private static String subtract(String num1, String num2) {
        // 前処理：前ゼロ除去
        num1 = removeLeadingZeros(num1);
        num2 = removeLeadingZeros(num2);

        int cmp = compare(num1, num2);
        return switch (cmp) {
            case 1 -> subtractPositive(num1, num2);
            case -1 -> "-" + subtractPositive(num2, num1);
            default -> "0";
        };
    }

    /**
     * 正の数同士の減算（num1 >= num2 が前提）
     */
    private static String subtractPositive(String num1, String num2) {
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        StringBuilder sb = new StringBuilder(num1.length());
        int borrow = 0;

        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(index1) - '0';
            int b = index2 >= 0 ? num2.charAt(index2) - '0' : 0;
            int diff = a - b - borrow;

            if (diff >= 0) {
                borrow = 0;
            } else {
                diff += 10;
                borrow = 1;
            }

            sb.append(diff);
            index1--;
            index2--;
        }

        sb.reverse();
        // 前ゼロ除去
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    /**
     * 大小比較  1:num1が大きい -1:num2が大きい 0:等しい
     */
    private static int compare(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 != len2) {
            return len1 > len2 ? 1 : -1;
        }
        for (int i = 0; i < len1; i++) {
            if (num1.charAt(i) > num2.charAt(i)) return 1;
            else if (num1.charAt(i) < num2.charAt(i)) return -1;
        }
        return 0;
    }

    /**
     * 先頭の余分なゼロを除去
     */
    private static String removeLeadingZeros(String num) {
        int dex = 0;
        while (dex < num.length() - 1 && num.charAt(dex) == '0') {
            dex++;
        }
        return num.substring(dex);
    }
}
