package game.enums;

public enum AttributeType {

    // 属性定数：インデックス、メニューID、表示名、1ポイントあたり上昇値、3勝毎の成長値
    HP(0, 1, "❤️HP", 10, 30),
    ATTACK(1, 2, "🗡️攻撃力", 2, 5),
    DEFENSE(2, 3, "🛡️防御力", 1, 3);

    private final int index;
    private final int menuId; // メニューの選択番号
    private final String name; // 属性の表示名
    private final int perPoint; // 1ポイント割り当て時の上昇量
    private final int growthPer3Wins; // 3勝毎に獲得する成長値
    private static final AttributeType[] ALL = values();

    AttributeType(int index, int menuId, String name, int perPoint, int growthPer3Wins) {
        this.index = index;
        this.menuId = menuId;
        this.name = name;
        this.perPoint = perPoint;
        this.growthPer3Wins = growthPer3Wins;
    }

    public int getIndex() {
        return index;
    }

    public int getMenuId() {
        return menuId;
    }

    public String getName() {
        return name;
    }

    public int getPerPoint() {
        return perPoint;
    }

    public int getGrowthPer3Wins() {
        return growthPer3Wins;
    }

    /**
     * ユーザーが入力したメニュー番号から、対応する属性の列挙型を取得する
     *
     * @param menuId 入力された選択番号
     * @return 対応する属性タイプ。無効な番号の場合はnullを返す
     */
    public static AttributeType getByMenuId(int menuId) {
        for (int i = 0; i < values().length; i++) {
            AttributeType type = ALL[i];
            if (menuId == type.getMenuId()) {
                return type;
            }
        }
        return null;
    }

    public static AttributeType[] getAll() {
        return ALL.clone();
    }
}
