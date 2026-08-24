package practice.oop.ex07;

/**
 * 実行クラス Ex07
 */
public class Ex07 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ArrayUtil.printArr(arr);
        double avg = ArrayUtil.getAverage(arr);
        System.out.println("平均値：" + avg);
    }

}
