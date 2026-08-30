package practice.string;

/**
 * 文字列中の連続数字の前後にアスタリスクを付与
 */
public class Ex08 {
    public static void main(String[] args) {
        String s = "Jkdi234klowe90a3";
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int start = i;
                // 連続する数字の終端までインデックスを進める
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                sb.append('*').append(s, start, i).append('*');
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }

        System.out.println(sb);

    }
}
