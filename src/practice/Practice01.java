package practice;
    /**
     * 問題：文字列を逆順に並び替える
     * 入力：Hello
     * 出力：olleH
     */
    public class Practice01 {
        public static void main(String[] args) {
            String str = "Hello";
            StringBuilder sb = new StringBuilder(str);
            String result = sb.reverse().toString();
            System.out.println(result);
        }
    }

