package practice.loop;

/**
 * 1～100の偶数の和を計算するクラス
 */
public class Ex01 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 2; i <= 100; i += 2) {
            sum += i;
        }
        System.out.println("1～100の偶数和：" + sum);
    }
}
