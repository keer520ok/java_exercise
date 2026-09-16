package practice.array;

/**
 * 課題：ある商業施設の四半期ごとの売上高（単位：万円）
 * 第1四半期：22,66,44
 * 第2四半期：77,33,88
 * 第3四半期：25,45,65
 * 第4四半期：11,66,99
 * <p>
 * 要件：各四半期の売上合計額、および年間の総売上高を計算する
 */
public class Ex13 {
    public static void main(String[] args) {
        // 四半期別月次売上データ（2次元配列：行=四半期、列=月）
        int[][] salesData = {
                {22, 66, 44},
                {77, 33, 88},
                {25, 45, 65},
                {11, 66, 99}
        };
        String[] quarterLabels = {"第一季度", "第二季度", "第三季度", "第四季度"};

        int yearTotal = 0; // 年間合計値を保持

        // 各四半期の合計を算出して出力
        for (int i = 0; i < salesData.length; i++) {
            int quarterSum = 0;
            // 四半期内の3ヶ月分を累計
            for (int amount : salesData[i]) {
                quarterSum += amount;
            }
            System.out.println(quarterLabels[i] + " 総売上高：" + quarterSum + " 万円");
            yearTotal += quarterSum; // 年間合計に加算
        }

        System.out.println("--------------------");
        System.out.println("全年総売上高：" + yearTotal + " 万円");
    }
}


