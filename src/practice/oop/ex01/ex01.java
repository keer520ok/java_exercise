package practice.oop.ex01;

/**
 * 問題：キャラクター戦闘シミュレーション（オブジェクト指向練習）
 * 我方：叉子　攻撃:220 防御:85 HP:1012.5 スキル倍率:1.2
 * 相手：長手　攻撃:210 防御:80 HP:1223.3 スキル倍率:1.3
 * 通常攻撃ダメージ = 攻撃力 - 相手防御力
 * スキルダメージ = 攻撃力 * スキル倍率 - 相手防御力
 */
public class ex01 {
    public static void main(String[] args) {
        Hero myHero = new Hero(220, 85, 1012.5, 1.2);
        Hero enemy = new Hero(210, 80, 1223.3, 1.3);

        double normalDmg = myHero.normalAttack(enemy);
        double skillDmg = myHero.skillAttack(enemy);

        System.out.println("==============================");
        System.out.println("通常攻撃ダメージ：" + normalDmg);
        System.out.println("スキル攻撃ダメージ：" + skillDmg);

        // 通常攻撃後敵のHPを更新
        enemy.setHp(enemy.getHp() - normalDmg);
        System.out.println("攻撃後の敵HP：" + enemy.getHp());
    }
}
