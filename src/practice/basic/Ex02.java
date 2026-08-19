package practice.basic;

import java.util.Scanner;

/**
 * BMI計算プログラム
 * 入力：身長(m)、体重(kg)
 * 出力：BMI値、身体状態、健康リスク
 * 問題種別：入出力・条件分岐練習
 */
public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("身長を入力してください（単位：m）：");
        double height = sc.nextDouble();
        System.out.print("体重を入力してください（単位：kg）：");
        double weight = sc.nextDouble();

        double bmi = getBMI(height, weight);
        BmiResult result = getBMIStatus(bmi);

        System.out.println("========================");
        System.out.printf("BMI指数：%.2f\n", bmi);
        System.out.println("身体状況：" + result.status);
        System.out.println("健康リスク：" + result.risk);

        sc.close();
    }

    /**
     * BMI数値を計算する
     *
     * @param height 身長（メートル）
     * @param weight 体重（キログラム）
     * @return BMI値
     */
    public static double getBMI(double height, double weight) {
        return weight / (height * height);
    }

    /**
     * BMIから身体状態と健康リスクを取得
     *
     * @param bmi BMI数値
     * @return BmiResult 結果オブジェクト
     */
    public static BmiResult getBMIStatus(double bmi) {
        String status;
        String risk;
        if (bmi < 18.5) {
            status = "やせ型";
            risk = "リスク一部上昇";
        } else if (bmi <= 23.9) {
            status = "普通";
            risk = "リスクなし";
        } else if (bmi <= 26.9) {
            status = "太り気味";
            risk = "リスク上昇";
        } else if (bmi <= 29.9) {
            status = "肥満";
            risk = "リスク中等度上昇";
        } else {
            status = "高度肥満";
            risk = "リスク大幅上昇";
        }
        return new BmiResult(status, risk);
    }
}

/**
 * BMI判定結果を格納するデータクラス【实体类】
 * フィールド：status 身体状況、risk 健康リスク
 */
class BmiResult {
    String status;
    String risk;

    // コンストラクタ 构造方法
    public BmiResult(String status, String risk) {
        this.status = status;
        this.risk = risk;
    }
}
