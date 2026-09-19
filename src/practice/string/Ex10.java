package practice.string;

/**
 * 文字列形式の整数をint型に変換する自前実装
 * 仕様：
 * - 文字列は数字のみで構成されること
 * - 桁数は1桁以上10桁以下であること
 * - 0で始まってはならないこと
 */
public class Ex10 {
    public static void main(String[] args) {
        String s = "9999999999";

        String regex = "[1-9]\\d{0,9}";
        if (!s.matches(regex)) {
            System.out.println("""
                    文字列が空です
                    数字以外の文字が含まれています
                    桁数は1～10桁の範囲である必要があります
                    0で始まる文字列は許可されません""");
        } else {
            int result = 0;
            // 1文字ずつ走査して数値に変換
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                // 数字文字かどうか判定
                if (c < '0' || c > '9') {
                    throw new NumberFormatException("数字以外の文字が含まれています：" + c);
                }
                // 文字コードの差を利用して文字→数値に変換し、桁を上げながら累積
                int digit = c - '0';
                result = result * 10 + digit;
            }
            System.out.println(result);
        }
    }
}
