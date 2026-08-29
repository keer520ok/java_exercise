package practice.string;

// 大数掛け算の実装
public class Ex05 {
    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));      // 56088
        System.out.println(multiply("999", "999"));      // 998001
        System.out.println(multiply("0", "12345"));      // 0
        System.out.println(multiply("1000", "1000"));    // 1000000
        System.out.println(multiply("009", "0009"));    // 81

    }

    /**
     * 2つの非負整数文字列の乗算結果を文字列で返す
     */
    private static String multiply(String num1, String num2) {
        num1 = removeLeadingZeros(num1);
        num2 = removeLeadingZeros(num2);
        // どちらか一方が0の場合、結果は0
        if ("0".equals(num1) || "0".equals(num2)) return "0";

        int len1 = num1.length();
        int len2 = num2.length();
        // 積の最大桁数は len1 + len2 なのでこの長さで配列を確保
        int[] digits = new int[len1 + len2];

        // 下位桁から順に各桁を掛け合わせ、対応位置に積を加算
        for (int i = len1 - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';
                // 掛け算結果と、配列に既に格納済みの値を合計
                int total = digit1 * digit2 + digits[i + j + 1];
                // 現在の桁には10で剰余した値を格納
                digits[i + j + 1] = total % 10;
                // 繰り上がりを1つ上位の桁へ加算（上書きではなく加算）
                digits[i + j] += total / 10;
            }
        }

        StringBuilder sb = new StringBuilder(digits.length);
        for (int d : digits) {
            if (sb.isEmpty() && d == 0) {
                continue;
            }
            sb.append(d);
        }
        return sb.toString();
    }

    /**
     * 先頭の余分なゼロを除去
     */
    private static String removeLeadingZeros(String num) {
        int idx = 0;
        while (idx < num.length() - 1 && num.charAt(idx) == '0') {
            idx++;
        }
        return num.substring(idx);
    }
}

