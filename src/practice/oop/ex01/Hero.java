package practice.oop.ex01;

/**
 * キャラクタークラス
 * 攻撃力、防御力、HP、スキル倍率を保持する
 */
public class Hero {
    private double attack;     // 攻撃力
    private double defense;    // 防御力
    private double hp;         // HP（体力）
    private double skillRate;  // スキルダメージ倍率

    public Hero(double attack, double defense, double hp, double skillRate) {
        this.attack = attack;
        this.defense = defense;
        this.hp = hp;
        this.skillRate = skillRate;
    }

    /**
     * 通常攻撃ダメージ計算：攻撃力 - 相手の防御力
     * @param target 攻撃対象
     * @return ダメージ（0より下回らない）
     */
    public double normalAttack(Hero target) {
        double damage = this.attack - target.defense;
        return Math.max(damage, 0);
    }

    /**
     * スキル攻撃ダメージ計算：攻撃力 * スキル倍率 - 相手の防御力
     * @param target 攻撃対象
     * @return ダメージ（0より下回らない）
     */
    public double skillAttack(Hero target) {
        double damage = this.attack * this.skillRate - target.defense;
        return Math.max(damage, 0);
    }

    public double getHp() {
        return hp;
    }

    /**
     * HPを設定、HPがマイナスにならないよう制限
     * @param hp 新しいHP値
     */
    public void setHp(double hp) {
        if (hp < 0) {
            hp = 0;
        }
        this.hp = hp;
    }
}
