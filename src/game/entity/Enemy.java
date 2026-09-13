package game.entity;


import game.enums.SkillPool;

import java.util.List;

public class Enemy extends GameCharacter {
    // 元の基礎値、絶対に変更しない
    private final int baseHp;
    private final int baseAtk;
    private final int baseDef;

    // 1勝利毎の上昇量、敵ごと固有
    private final int growHp;
    private final int growAtk;
    private final int growDef;

    private final List<SkillPool> skillList;


    private Enemy(EnemyBuilder enemyBuilder) {
        super(enemyBuilder.name
                , enemyBuilder.baseHp
                , enemyBuilder.baseAtk
                , enemyBuilder.baseDef);

        this.baseHp = enemyBuilder.baseHp;
        this.baseAtk = enemyBuilder.baseAtk;
        this.baseDef = enemyBuilder.baseDef;

        this.growHp = enemyBuilder.growHp;
        this.growAtk = enemyBuilder.growAtk;
        this.growDef = enemyBuilder.growDef;

        this.skillList = enemyBuilder.skillList;
    }

    public static class EnemyBuilder {
        private String name;
        private int baseHp;
        private int baseAtk;
        private int baseDef;

        // 1勝利毎の上昇量、敵ごと固有
        private int growHp = 10;
        private int growAtk = 3;
        private int growDef = 2;
        private List<SkillPool> skillList;

        public EnemyBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public EnemyBuilder setSkillList(List<SkillPool> skillList) {
            this.skillList = skillList;
            return this;
        }

        public EnemyBuilder setBaseHp(int baseHp) {
            this.baseHp = baseHp;
            return this;
        }

        public EnemyBuilder setBaseAtk(int baseAtk) {
            this.baseAtk = baseAtk;
            return this;
        }

        public EnemyBuilder setBaseDef(int baseDef) {
            this.baseDef = baseDef;
            return this;
        }

        public EnemyBuilder setGrowHp(int growHp) {
            this.growHp = growHp;
            return this;
        }

        public EnemyBuilder setGrowAtk(int growAtk) {
            this.growAtk = growAtk;
            return this;
        }

        public EnemyBuilder setGrowDef(int growDef) {
            this.growDef = growDef;
            return this;
        }

        public Enemy build() {
            return new Enemy(this);
        }
    }

    public String autoUseSkill(GameCharacter target) {
        SkillPool skill;
        int r = RAND.nextInt(100) + 1;
        if (r <= 80) {
            skill = SkillPool.ENEMY_BASIC;
        } else {
            // 使用可能なスキルだけを対象にする
            List<SkillPool> usableSkills = skillList.stream()
                    .filter(this::canUseSkill)
                    .toList();

            skill = usableSkills.isEmpty()
                    ? SkillPool.ENEMY_BASIC
                    : usableSkills.get(RAND.nextInt(usableSkills.size()));
        }

        return super.useSkill(skill, target);
    }

    /**
     * 戦闘勝利回数に応じてキャラクターのステータスを成長させる
     *
     * @param winCount 勝利回数
     */
    @Override
    public void applyBattleGrowth(int winCount) {
        // 基礎HP + 勝利回数 × HP成長値 から現在のHPを計算
        int calcHp = baseHp + winCount * growHp;
        // 基礎攻撃力 + 勝利回数 × 攻撃成長値 から現在の攻撃力を計算
        int calcAtk = baseAtk + winCount * growAtk;
        // 基礎防御力 + 勝利回数 × 防御成長値 から現在の防御力を計算
        int calcDef = baseDef + winCount * growDef;

        // 最大HPを更新
        setMaxHP(calcHp);
        // HPを現在の最大HPに合わせて回復
        setHp(calcHp);
        // 攻撃力を更新
        setBaseAtk(calcAtk);
        // 防御力を更新
        setBaseDef(calcDef);
    }
}
