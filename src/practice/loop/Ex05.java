package practice.loop;

/**
 * 紙を折りたたみ、厚みが珠穆朗瑪峰の高さ以上になる折り回数を計算するクラス
 * 初期厚 0.1mm、目標高 8848860mm
 */
public class Ex05 {
    public static void main(String[] args) {
        // 今回の問題：初期厚 0.1mm
        int count = calcFoldCount(0.1);
        System.out.println("必要な折り回数：" + count);
    }

    /**
     * 指定した初期厚さの紙が珠穆朗瑪峰の高さを超えるまでの折り回数を計算
     *
     * @param initThickness 紙の初期厚さ（単位：mm）
     * @return 目標高を超えるのに必要な折り回数
     */
    public static int calcFoldCount(double initThickness) {
        final double TARGET_HEIGHT = 8848860;
        double thickness = initThickness;
        int foldTimes = 0;

        while (thickness < TARGET_HEIGHT) {
            thickness *= 2;
            foldTimes++;
        }
        return foldTimes;
    }
}
