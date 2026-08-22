package practice.condition;

import java.util.Scanner;

/**
 * 宅配業者の送料計算ルール
 * （初回重量 1kg、超過分は kg 単位、1kg 未満でも 1kg とみなす）
 * - 初回 1kg：10 元
 * - 超過分 1～5kg：1kg ごとに＋2 元
 * - 超過分 5kg 超：1kg ごとに＋1.5 元
 */
public class Ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double weight;
        while (true) {
            System.out.println("荷物の重量(kg)を入力してください：");
            weight = sc.nextDouble();
            if (weight < 0) System.out.println("荷物の重量(kg)<0、再入力");
            else break;
        }
        double cost = calculateShippingCost(weight);
        System.out.println("送料：" + cost + "元");
    }

    /**
     * 送料を計算するメソッド
     *
     * @param weight 荷物の実重量
     * @return 計算後の送料
     */
    private static double calculateShippingCost(double weight) {
        // 1kg以内の場合
        if (weight <= 1) return 10;

        // 1kg以外の場合
        double overWeight = Math.ceil(weight - 1);
        if (overWeight <= 5) {
            // 超過分1～5kg
            return 10 + overWeight * 2;
        } else {
            // 超過分が5kgを超える場合
            return 10 + 5 * 2 + (overWeight - 5) * 1.5;
        }
    }
}