package practice.condition;

import java.util.Scanner;

/**
 * ゲームキャラクターの最終HPを計算するクラス
 * 初期最大HP:200、HP下限1、上限200
 * ダメージ値X、回復値Yをキーボード入力
 */
public class Ex01 {
    private static final int MAX_HP = 200;
    private static final int MIN_HP = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("ダメージXを入力：");
        int x = sc.nextInt();
        System.out.print("回復量Yを入力：");
        int y = sc.nextInt();

        int finalHp = calcGameHp(x, y);
        System.out.println("最終HP：" + finalHp);
        sc.close();

    }

    /**
     * ダメージと回復量から最終HPを計算するメソッド
     *
     * @param damage 受けるダメージ
     * @param heal   スキルによる回復量
     * @return 計算後の最終HP
     */
    public static int calcGameHp(int damage, int heal) {
        int hp = MAX_HP;
        hp -= damage;
        if (hp < MIN_HP) {
            hp = MIN_HP;
        }
        hp += heal;
        if (hp > MAX_HP) {
            hp = MAX_HP;
        }
        return hp;
    }
}
