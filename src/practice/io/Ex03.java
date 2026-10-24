package practice.io;

import java.io.*;
import java.util.Arrays;

/**
 * ファイル内のハイフン区切り数値を読み込み、昇順ソートして元ファイルに上書きする
 */
public class Ex03 {
    public static void main(String[] args) {
        String filePath = "./numbers.txt";

        try {
            // 1. ファイルから元の文字列を読み込む
            String original = readFile(filePath);
            System.out.println("ソート前：" + original);

            // 2. 数値を分解して昇順に並べ替え
            String sorted = sortHyphenNumbers(original);
            System.out.println("ソート後：" + sorted);

            // 3. ソート済みの文字列をファイルに上書き
            writeFile(filePath, sorted);
            System.out.println("ファイルの更新が完了しました。");

        } catch (IOException e) {
            System.out.println("ファイル処理中にエラーが発生しました：" + e.getMessage());
        }
    }

    /**
     * 指定パスのファイルから1行読み込む
     *
     * @param filePath 対象ファイルパス
     * @return 読み込んだ文字列
     * @throws IOException 読み込みエラー
     */
    private static String readFile(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return br.readLine();
        }
    }

    /**
     * ハイフン区切りの数値文字列を昇順にソートする
     *
     * @param content ハイフン区切りの数値文字列
     * @return ソート済みのハイフン区切り文字列
     */
    private static String sortHyphenNumbers(String content) {
        // ハイフンで分割して各数値を取り出す
        String[] numStrs = content.split("-");
        int[] numbers = new int[numStrs.length];
        for (int i = 0; i < numStrs.length; i++) {
            numbers[i] = Integer.parseInt(numStrs[i].trim());
        }

        // 昇順ソート
        Arrays.sort(numbers);

        // 再びハイフンで結合して文字列に戻す
        return String.join("-", Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new));
    }

    /**
     * 指定パスのファイルに文字列を上書き保存する
     *
     * @param filePath 対象ファイルパス
     * @param content  書き込む文字列
     * @throws IOException 書き込みエラー
     */
    private static void writeFile(String filePath, String content) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(content);
        }
    }
}
