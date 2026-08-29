package practice.string;

/**
 * 文字列最後の単語の長さを取得（末尾空白対応）
 */
public class Ex07 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));               // 5
        System.out.println(lengthOfLastWord("   fly me   to   the moon  ")); // 4
        System.out.println(lengthOfLastWord("  "));    // 0
        System.out.println(lengthOfLastWord(""));    // 0
    }

    public static int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        int count = 0;

        // ステップ1：末尾の連続する空白をすべてスキップ
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }

        // ステップ2：空白に出会うまで文字数を数える
        while (index >= 0 && s.charAt(index) != ' ') {
            count++;
            index--;
        }

        return count;
    }
}
