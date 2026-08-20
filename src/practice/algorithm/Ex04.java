package practice.algorithm;

import java.util.Scanner;

/**
 * 秒数を 時・分・秒 に変換するクラス
 */
public class Ex04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();

        // 1時間 = 3600秒
        int hours = time / 3600;
        // 残りの秒数
        int remainSeconds = time % 3600;
        // 1分　= 60秒
        int minutes = remainSeconds / 60;
        int seconds = remainSeconds % 60;

        System.out.println(hours + " " + minutes + " " + seconds);
        sc.close();
    }
}


