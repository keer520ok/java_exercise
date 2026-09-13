package game.entity;

import game.enums.AttributeType;
import game.enums.SkillPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hero extends GameCharacter {
    private static final Random RANDOM = new Random();
    public static final int BASE_HP = 100;      // 初始血量
    public static final int BASE_ATK = 10;      // 初始攻击
    public static final int BASE_DEF = 0;

    private final int permanentBaseHp;
    private final int permanentBaseAtk;
    private final int permanentBaseDef;
    private final List<SkillPool> ownSkills = new ArrayList<>();

    {
        ownSkills.add(SkillPool.NORMAL_ATTACK);
        ownSkills.add(SkillPool.FIRE_SLASH);
        ownSkills.add(SkillPool.HEAL);
        ownSkills.add(SkillPool.WAR_CRY);
        ownSkills.add(SkillPool.IRON_WALL);
    }


    public Hero(String name, int hp, int attack, int defense) {
        super(name, hp, attack, defense);
        this.permanentBaseHp = hp;
        this.permanentBaseAtk = attack;
        this.permanentBaseDef = defense;
    }

    @Override
    public void applyBattleGrowth(int winCount) {
        // 何段階成長したか（3勝につき1段階）
        int growthTier = winCount / 3;
        // 各属性の成長値を計算して反映
        int calcHp = this.permanentBaseHp + AttributeType.HP.getGrowthPer3Wins() * growthTier;
        int calcAtk = this.permanentBaseAtk + AttributeType.ATTACK.getGrowthPer3Wins() * growthTier;
        int calcDef = this.permanentBaseDef + AttributeType.DEFENSE.getGrowthPer3Wins() * growthTier;

        setMaxHP(calcHp);
        setHp(calcHp);
        setBaseAtk(calcAtk);
        setBaseDef(calcDef);
    }

    /**
     * スキル選択メニューを表示
     */
    public void printSkillMenu() {
        System.out.println("◆ スキル一覧 ◆");
        for (SkillPool skill : ownSkills) {
            System.out.printf("%d %s(%s)%n",
                    skill.getCode(), skill.getSkillName(), skill.getEffectDesc());
        }
        System.out.print("番号を入力：");
    }

    public List<SkillPool> getSkills() {
        return ownSkills;
    }

    public static int calcFinalStat(AttributeType type, int assignPoint) {
        int baseValue = switch (type) {
            case HP -> BASE_HP;
            case ATTACK -> BASE_ATK;
            case DEFENSE -> BASE_DEF;
        };
        return baseValue + assignPoint * type.getPerPoint();
    }

}
