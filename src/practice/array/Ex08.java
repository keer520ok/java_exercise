package practice.array;

import java.util.Scanner;

/**
 * 学生成績集計
 * 合格率、平均点、最高点を計算
 */
public class Ex08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scores = new int[10];
        // 要件1：10名分の点数を入力、0～100以外は再入力
        int i = 0;
        while (i < scores.length) {
            System.out.println((i + 1) + "人目の点数を入力(0~100): ");
            int num = sc.nextInt();
            if (num < 0 || num > 100) {
                System.out.println("点数無効、再入力。");
            } else {
                scores[i] = num;
                i++;
            }
        }
        sc.close();

        int passCount = getPassCount(scores);
        double passRate = passCount / 10.0;

        int sum = getTotal(scores);
        double avg = sum / 10.0;

        int max = getMaxScore(scores);

        System.out.println("合格者数：" + passCount);
        System.out.println("合格率：" + passRate * 100 + "%");
        System.out.println("平均点：" + avg);
        System.out.println("最高点：" + max);
    }

    /**
     * 合格者数を取得（60点以上を合格とする）
     *
     * @param arr 点数配列
     * @return 合格した人数
     */
    private static int getPassCount(int[] arr) {
        int count = 0;
        for (int score : arr) {
            if (score >= 60) {
                count++;
            }
        }
        return count;
    }

    /**
     * 点数の合計を計算
     *
     * @param arr 点数配列
     * @return 合計点
     */
    private static int getTotal(int[] arr) {
        int sum = 0;
        for (int score : arr) {
            sum += score;
        }
        return sum;
    }

    /**
     * 配列の最高点を返す
     *
     * @param arr 点数配列
     * @return 最高点
     */
    private static int getMaxScore(int[] arr) {
        int max = arr[0];
        for (int score : arr) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }
}
