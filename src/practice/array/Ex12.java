package practice.array;

import java.util.Random;

/**
 * 学生会会長選挙シミュレーション
 * 総投票数と候補者数を引数で指定可能。乱数で投票を模擬し、得票数・得票率、棄権情報を集計する。
 * 0：棄権、1～N：各候補者へ投票。同得票の候補はすべて出力する。
 */
public class Ex12 {
    private static final Random r = new Random();

    public static void main(String[] args) {
        int total = 1000;
        int candidateNum = 5;
        int[] count = voteSimulation(total, candidateNum);
        printVoteResult(count, total);
        printMaxCandidate(count);

    }

    /**
     * 投票を乱数でシミュレーションし、集計配列を返す
     *
     * @param total        総投票数
     * @param candidateNum 候補者人数
     * @return 集計配列 index0：棄権、1～candidateNum：各候補
     */
    private static int[] voteSimulation(int total, int candidateNum) {
        int[] count = new int[candidateNum + 1];
        for (int i = 0; i < total; i++) {
            int num = r.nextInt(count.length);
            count[num]++;
        }
        return count;
    }

    /**
     * 各候補の得票、棄権情報を出力
     *
     * @param count 集計配列
     * @param total 総投票数
     */
    private static void printVoteResult(int[] count, int total) {

        for (int i = 1; i < count.length; i++) {
            System.out.print(i + "号候補：得票：" + count[i]);
            System.out.println("、得票率:" + count[i] / (double) total * 100.0 + "%");
        }

        int abandon = count[0];
        double abandonRate = abandon / (double) total * 100.0;
        System.out.println("棄権:" + abandon + "、棄権率:" + abandonRate + "%");
    }

    /**
     * 最高得票の候補（同点の場合複数）を出力
     *
     * @param count 集計配列
     */
    private static void printMaxCandidate(int[] count) {

        int max = count[1];
        for (int i = 2; i < count.length; i++) {
            max = Math.max(max, count[i]);
        }

        System.out.print("最も得票が多い候補：");
        for (int i = 1; i < count.length; i++) {
            if (count[i] == max) {
                System.out.print(i + "号,");
            }
        }
        System.out.printf("得票数：%d%n", max);
    }
}
