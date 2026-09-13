package game.entity;

import game.enums.SkillPool;

import java.util.concurrent.ThreadLocalRandom;

public abstract class GameCharacter {
    private String name;
    private int maxHP;
    private int hp;
    private int baseAtk; // 基礎攻撃力
    private int baseDef; // 基礎防御力


    // ===== バフ状態 =====
    private int atkBuff;    // 攻撃バフ上昇値
    private int defBuff;    // 防御バフ上昇値
    private int buffTurns;  // バフ残りターン
    private int damageReduction;

    protected static final ThreadLocalRandom RAND = ThreadLocalRandom.current();

    public GameCharacter(String name, int maxHp, int baseAtk, int baseDef) {
        this.name = name;
        this.maxHP = maxHp;
        this.hp = maxHp;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.atkBuff = 0;
        this.defBuff = 0;
        this.buffTurns = 0;
        this.damageReduction = 0;
    }

    public String useSkill(SkillPool skill, GameCharacter target) {
        if (!canUseSkill(skill)) {
            return null;
        }
        // 2. HP消費
        consumeHp(skill.getHpCost());
        // 3. スキルタイプ別決済
        switch (skill.getType()) {
            case DAMAGE -> {
                int dmg = calcActualDamage(skill, target);
                target.takeDamage(dmg);
                return String.format("💥%sを発動！%sに%dダメージを与えた！%n"
                        , skill.getSkillName(), target.getName(), dmg);
            }
            case HEAL -> {
                int amount = calcHealAmount(skill);
                heal(amount);
                return String.format("💚%sを発動！%sがHPを%d回復した！%n"
                        , skill.getSkillName(), this.getName(), amount);
            }
            case BUFF -> {
                addBuff(skill.getAtkBuffValue(), skill.getDefBuffValue()
                        , skill.getDamageReduction(), skill.getDuration());
                return String.format("❇️%sを発動！能力が上昇した！%n"
                        , skill.getSkillName());
            }
            default -> {
                return null;
            }
        }
    }

    /**
     * スキルを使用した際の実ダメージを計算する
     *
     * @param skill  使用するスキル
     * @param target ダメージを受ける対象キャラクター
     * @return 計算後の最終ダメージ（最低1を保証）
     */
    public int calcActualDamage(SkillPool skill, GameCharacter target) {
        // スキルのダメージ倍率（百分率）
        int damageRate = skill.getDamageRateMin();
        //スキルのヒット回数
        int hitCount = skill.getComboCount();
        // 基礎ダメージ：攻撃力 × 倍率
        double baseDamage = this.getCurrentAtk() * damageRate / 100.0;
        // 防御力減算後
        double afterDefense = baseDamage - target.getCurrentDef();
        // ダメージ軽減率適用後
        double afterReduction = afterDefense * (1 - target.getDamageReduction() / 100.0);
        // 端数丸め + 単発最低1ダメージ保証
        int damagePerHit = (int) Math.round(afterReduction);
        damagePerHit = Math.max(1, damagePerHit);
        // 連撃回数を乗算して返却
        return damagePerHit * hitCount;
    }

    /**
     * @param skill 使用するスキル
     * @return 計算後の回復量
     */
    public int calcHealAmount(SkillPool skill) {
        return RAND.nextInt(skill.getHealMax() - skill.getHealMin() + 1) + skill.getHealMin();
    }

    /**
     * ダメージを受ける（HPは0を下回らない）
     */
    public void takeDamage(int damage) {
        int tempHp = this.getHp() - damage;
        this.setHp(tempHp);
    }

    /**
     * 回復する（HPは最大値を超えない）
     */
    public void heal(int amount) {
        int tempHp = this.hp + amount;
        this.setHp(tempHp);
    }

    /**
     * スキル発動前にHP消費可能か判定
     *
     * @return true=発動可能、false=HP不足
     */
    public boolean canUseSkill(SkillPool skill) {
        return hp > skill.getHpCost();
    }

    /**
     * HPを消費する
     */
    public void consumeHp(int costHp) {
        if (costHp <= 0) return;
        int beforeHp = this.hp; // 変更前のHPを退避
        setHp(this.hp - costHp);
        System.out.printf("HP：%d → %d%n", beforeHp, this.hp);

    }

    /**
     * 生存判定
     */
    public boolean isAlive() {
        return hp > 0;
    }

    /**
     * バフを付与する
     */
    public void addBuff(int atkUp, int defUp, int damageReduction, int turns) {
        this.atkBuff = (int) Math.ceil(baseAtk * atkUp / 100.0);
        this.defBuff = (int) Math.ceil(baseAtk * defUp / 100.0);
        this.damageReduction = damageReduction;
        this.buffTurns = turns;
    }

    /**
     * ターン経過処理：バフ残り時間を1減らす
     */
    public void tickBuff() {
        if (buffTurns > 0) {
            buffTurns--;
            if (buffTurns == 0) {
                this.atkBuff = 0;
                this.defBuff = 0;
                this.damageReduction = 0;
            }
        }
    }

    /**
     * 戦闘勝利回数に応じてキャラクターのステータスを成長させる
     *
     * @param winCount 勝利回数
     */
    public abstract void applyBattleGrowth(int winCount);

    /**
     * 現在の実攻撃力（基礎＋バフ）
     */
    public int getCurrentAtk() {
        return baseAtk + atkBuff;
    }

    /**
     * 現在の実防御力（基礎＋バフ）
     */
    public int getCurrentDef() {
        return baseDef + defBuff;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void setHp(int hp) {
        if (hp > maxHP) hp = maxHP;
        if (hp < 0) hp = 0;
        this.hp = hp;
    }

    public void setBaseAtk(int baseAtk) {
        this.baseAtk = baseAtk;
    }

    public void setBaseDef(int baseDef) {
        this.baseDef = baseDef;
    }


    public String getName() {
        return name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getHp() {
        return hp;
    }

    public int getBaseAtk() {
        return baseAtk;
    }

    public int getBaseDef() {
        return baseDef;
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    public GameCharacter setDamageReduction(int damageReduction) {
        this.damageReduction = damageReduction;
        return this;
    }

    @Override
    public String toString() {
        return String.format("[%s、HP：%d/%d、攻撃：%d、防御：%d]", name, hp, maxHP, baseAtk, baseDef);
    }

}


