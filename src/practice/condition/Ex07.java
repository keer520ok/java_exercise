package practice.condition;

import java.util.Scanner;

/**
 * 储値カードのチャージ金額からカード残高を計算するクラス
 */
public class Ex07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("チャージ金額を入力してください：");
        int charge = sc.nextInt();
        sc.close();

        //チャージ金額別プレゼント金額
        int gift;
        switch (charge) {
            case 1000:
                gift = 200;
                break;
            case 2000:
                gift = 500;
                break;
            case 3000:
                gift = 700;
                break;
            case 5000:
                gift = 1300;
                break;
            case 10000:
                gift = 2500;
                break;
            case 20000:
                gift = 6000;
                break;
            case 50000:
                gift = 15000;
                break;
            default:
                System.out.println("対応しているチャージ金額ではありません");
                return;
        }
        int balance = charge + gift;
        System.out.println("プレゼント金額：" + gift);
        System.out.println("カード残高：" + balance);
    }
}
