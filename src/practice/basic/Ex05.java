package practice.basic;

import java.util.Scanner;

/**
 * デリバリーアプリの割引計算、どちらが安いか比較するクラス
 */
public class Ex05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double originalPrice = sc.nextDouble();

        // この：9割引
        double appADiscount = originalPrice * 0.9;
        // その：300円以上で100円割引
        double appBDiscount;
        if (originalPrice >= 300) {
            appBDiscount = originalPrice - 100;
        } else {
            appBDiscount = originalPrice;
        }

        System.out.println("このApp支払額：" + appADiscount);
        System.out.println("そのApp支払額：" + appBDiscount);

        if (appADiscount < appBDiscount) {
            System.out.println("このAppの方がお得です");
        } else if (appBDiscount < appADiscount) {
            System.out.println("そのAppの方がお得です");
        } else {
            System.out.println("二つのアプリの金額は同じです");
        }
        sc.close();
    }
}
