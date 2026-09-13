package game.enums;

public enum SkillPool {
    // ===== プレイヤー用スキル =====
    // 通常攻撃：消費少ない、安定ダメージ
    NORMAL_ATTACK(new SkillPoolBuilder()
            .setCode(1)
            .setSkillName("通常攻撃")
            .setType(SkillEffect.DAMAGE)
            .setDamageRateMin(100)
            .setEffectDesc("現在の攻撃力100%倍率のダメージを与える")
            .build()
    ),

    // 火炎斬：HP消費大、高ダメージ倍率
    FIRE_SLASH(new SkillPoolBuilder()
            .setCode(2)
            .setSkillName("火炎斬り")
            .setType(SkillEffect.DAMAGE)
            .setHpCost(10)
            .setDamageRateMin(140)
            .setEffectDesc("HPを10消費し、現在の攻撃力140%倍率のダメージを与える")
            .build()
    ),
    // 回復術：HP消費、ランダム回復
    HEAL(new SkillPoolBuilder()
            .setCode(3)
            .setSkillName("回復術")
            .setType(SkillEffect.HEAL)
            .setHpCost(10)
            .setHealMin(20)
            .setHealMax(40)
            .setEffectDesc("HPを10消費し、自身のHPを20～40回復する")
            .build()),

    // 気合い：バフスキル、攻撃防御上昇、3ターン持続
    WAR_CRY(new SkillPoolBuilder()
            .setCode(4)
            .setSkillName("気合い")
            .setType(SkillEffect.BUFF)
            .setAtkBuffValue(20)
            .setDefBuffValue(20)
            .setDuration(3)
            .setEffectDesc("攻撃力20%、防御力20%上昇、3ターン継続")
    ),
    //5, "鉄壁", 12, EffectType.BUFF, 0, 0, 30, 2)
    IRON_WALL(new SkillPoolBuilder()
            .setCode(5)
            .setSkillName("鉄壁")
            .setType(SkillEffect.BUFF)
            .setComboDecayRate(60)
            .setDuration(2)
            .setEffectDesc("被ダメージ60%減衰、2ターン継続")
            .build()
    ),

    // ===== 敵専用スキル =====
    ENEMY_BASIC(new SkillPoolBuilder()
            //  .setCode(10)
            .setSkillName("通常攻撃")
            .setType(SkillEffect.DAMAGE)
            .setDamageRateMin(100)
            .setEffectDesc("")
    ),

    POISON(new SkillPoolBuilder()
            //.setCode(11)
            .setSkillName("毒噴射")
            .setType(SkillEffect.DAMAGE)
            .setHpCost(5)
            .setDamageRateMin(120)
            .setDamageRateMax(150)
            .setEffectDesc("")
    ),

    ENRAGE(new SkillPoolBuilder()
            //    .setCode(12)
            .setSkillName("怒り")
            .setType(SkillEffect.BUFF)
            .setAtkBuffValue(10)
            .setDefBuffValue(0)
            .setDuration(3)
            .setEffectDesc("")
    );


    private final int code;                 // スキルコード
    private final String skillName;         // スキル名
    private final SkillEffect type;         // スキル効果種別
    private final int hpCost;               // 発動時のHP消費量

    private final int damageRateMin;        // ダメージ倍率下限
    private final int damageRateMax;        // ダメージ倍率上限
    private final int healMin;              // 回復量下限
    private final int healMax;              // 回復量上限
    private final int atkBuffValue;         // 攻撃バフ値
    private final int defBuffValue;         // 防御バフ値
    private final int damageReduction;       // コンボダメージ減衰率（%）

    private final int comboCount;           // ★コンボ段数：連続攻撃回数、1で単発攻撃
    private final int duration;             // 効果持続ターン数
    private final String effectDesc;        // 効果説明文


    SkillPool(SkillPoolBuilder builder) {
        this.code = builder.code;
        this.skillName = builder.skillName;
        this.type = builder.type;
        this.hpCost = builder.hpCost;
        this.damageRateMin = builder.damageRateMin;
        this.damageRateMax = builder.damageRateMax;
        this.healMin = builder.healMin;
        this.healMax = builder.healMax;
        this.atkBuffValue = builder.atkBuffValue;
        this.defBuffValue = builder.defBuffValue;
        this.comboCount = builder.comboCount;
        this.duration = builder.duration;
        this.effectDesc = builder.effectDesc;
        this.damageReduction = builder.damageReduction;
    }

    private static class SkillPoolBuilder {
        private int code;                 // スキルコード
        private String skillName;         // スキル名
        private SkillEffect type;         // スキル効果種別
        private int hpCost;               //  発動時のHP消費量
        private int damageRateMin;        // ダメージ倍率下限
        private int damageRateMax;        // ダメージ倍率上限
        private int healMin;              // 回復量下限
        private int healMax;              // 回復量上限
        private int atkBuffValue;         // 攻撃バフ値
        private int defBuffValue;         // 防御バフ値
        private int comboCount = 1;           // ★コンボ段数：連続攻撃回数、1で単発攻撃
        private int duration;             // 効果持続ターン数
        private String effectDesc;        // 効果説明文
        private int damageReduction;       // ダメージ減衰率（%）

        public SkillPoolBuilder setCode(int code) {
            this.code = code;
            return this;
        }

        public SkillPoolBuilder setComboDecayRate(int damageReduction) {
            this.damageReduction = damageReduction;
            return this;
        }

        public SkillPoolBuilder setSkillName(String skillName) {
            this.skillName = skillName;
            return this;
        }

        public SkillPoolBuilder setType(SkillEffect type) {
            this.type = type;
            return this;
        }

        public SkillPoolBuilder setHpCost(int hpCost) {
            this.hpCost = hpCost;
            return this;
        }

        public SkillPoolBuilder setDamageRateMin(int damageRateMin) {
            this.damageRateMin = damageRateMin;
            return this;
        }

        public SkillPoolBuilder setDamageRateMax(int damageRateMax) {
            this.damageRateMax = damageRateMax;
            return this;
        }

        public SkillPoolBuilder setHealMin(int healMin) {
            this.healMin = healMin;
            return this;
        }

        public SkillPoolBuilder setHealMax(int healMax) {
            this.healMax = healMax;
            return this;
        }

        public SkillPoolBuilder setAtkBuffValue(int atkBuffValue) {
            this.atkBuffValue = atkBuffValue;
            return this;
        }

        public SkillPoolBuilder setDefBuffValue(int defBuffValue) {
            this.defBuffValue = defBuffValue;
            return this;
        }

        public SkillPoolBuilder setComboCount(int comboCount) {
            this.comboCount = comboCount;
            return this;
        }

        public SkillPoolBuilder setDuration(int duration) {
            this.duration = duration;
            return this;
        }

        public SkillPoolBuilder setEffectDesc(String effectDesc) {
            this.effectDesc = effectDesc;
            return this;
        }

        private SkillPoolBuilder build() {
            return this;
        }
    }

    public int getDefBuffValue() {
        return defBuffValue;
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    public int getCode() {
        return code;
    }

    public String getSkillName() {
        return skillName;
    }

    public SkillEffect getType() {
        return type;
    }

    public int getHpCost() {
        return hpCost;
    }

    public int getDamageRateMin() {
        return damageRateMin;
    }

    public int getDamageRateMax() {
        return damageRateMax;
    }

    public int getHealMin() {
        return healMin;
    }

    public int getHealMax() {
        return healMax;
    }

    public int getAtkBuffValue() {
        return atkBuffValue;
    }

    public int getComboCount() {
        return comboCount;
    }

    public int getDuration() {
        return duration;
    }

    public String getEffectDesc() {
        return effectDesc;
    }


    private static final SkillPool[] skills = SkillPool.values();

    // 全部取得、ループ用
    public static SkillPool[] getAll() {
        return skills.clone();
    }

    public static SkillPool fromCode(int code) {
        for (SkillPool st : skills) {
            if (st.getCode() == code) return st;
        }
        //   throw new IllegalArgumentException("存在しないスキルコード:" + code);
        return null;
    }
}
