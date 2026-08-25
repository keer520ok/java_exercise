package practice.oop.ex09;

/**
 * 注文ステータス 列挙型
 */
public enum OrderStatus {
    WAIT_PAY("待支払い"),
    PROCESSING("処理中"),
    SHIPPED("発送済み"),
    DELIVERING("配送中"),
    RECEIVED("配達完了"),
    CANCELLED("キャンセル済み");

    private final String desc;

    OrderStatus(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
