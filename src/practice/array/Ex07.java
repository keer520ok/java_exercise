package practice.array;

import java.util.Scanner;

/**
 * 飛び込み審査員採点計算
 * 最高点、最低点を除いて平均点を求める
 * 飛び込み競技、5 人の審査員が 0～100 点で採点する。最高点 1 つ、最低点 1 つを削除し、残り 3 点の平均を最終得点とする。
 * 要件
 * 1. キーボードから 5 個の整数を配列へ入力。点数が 0～100 を超えたら再入力させる
 * 2. 配列の最大値、最小値を求めるメソッドを別々に定義
 * 3. 5 点の合計点を計算
 * 4. 合計 − 最大値 − 最小値、残り 3 件の平均を算出
 */

public class Ex07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scores = inputScores(5, sc);
        double avg = calcAverageTrim(scores);
        System.out.println("除外後の平均点：：" + avg);
    }

    /**
     * 審査員の点数を入力し、int配列で返す
     *
     * @param count 審査員人数
     * @param sc    Scannerインスタンス（外部から渡す）
     * @return 点数配列
     */
    private static int[] inputScores(int count, Scanner sc) {
        int[] scores = new int[count];
        int i = 0;
        while (i < count) {
            System.out.println((i + 1) + "番目の審査員の点数を入力(0~100): ");
            int num = sc.nextInt();
            if (num < 0 || num > 100) {
                System.out.println("点数は0～100の間で入力してください。再入力。");
            } else {
                scores[i] = num;
                i++;
            }
        }
        return scores;
    }

    /**
     * 配列から最大値を返す
     *
     * @param scores 点数配列
     * @return 最大値
     */
    private static int getMax(int[] scores) {
        int max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            max = Math.max(max, scores[i]);
        }
        return max;
    }

    /**
     * 配列から最小値を返す
     *
     * @param scores 点数配列
     * @return 最小値
     */
    private static int getMin(int[] scores) {
        int min = scores[0];
        for (int i = 1; i < scores.length; i++) {
            min = Math.min(min, scores[i]);
        }
        return min;
    }

    /**
     * 配列の合計値を返す
     *
     * @param scores 点数配列
     * @return 合計
     */
    private static int getSum(int[] scores) {
        int sum = 0;
        for (int i : scores) {
            sum += i;
        }
        return sum;
    }

    /**
     * 最高点と最低点を1つずつ除外し、残り点数の平均値を計算する
     *
     * @param scores 点数配列
     * @return 除外後の平均値
     */
    private static double calcAverageTrim(int[] scores) {
        //"点数配列の要素数は3個以上必要です"
        if (scores == null || scores.length < 3) {
            return 0.0;
        }
        int validCount = scores.length - 2;
        int total = getSum(scores) - getMax(scores) - getMin(scores);
        return total / (double) validCount;
    }
}
