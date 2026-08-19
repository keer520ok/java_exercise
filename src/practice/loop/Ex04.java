package practice.loop;

/**
 * 複利計算：元金が2倍になる年数を算出するクラス
 * 初期金額 100000、年複利 1.7%
 */
public class Ex04 {
    public static void main(String[] args) {
        int year = calcDoubleYear(100000);
        System.out.println("元金が2倍になる年数：" + year);
    }

    /**
     * 年複利1.7%で元金が2倍になるまでの年数を返す
     *
     * @param money 元金
     * @return 必要な年数
     */
    public static int calcDoubleYear(double money) {
        double rate = 0.017;
        int target = 200000;
        int count = 0;

        while (money < target) {
            money = money * (1 + rate);
            count++;
        }
        return count;
    }
}
