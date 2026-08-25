package practice.oop.ex09;

/**
 * 実行クラス Ex09
 */
public class Ex09 {
    public static void main(String[] args) {
        OrderStatus status = OrderStatus.WAIT_PAY;
        System.out.println("ステータス：" + status);
        System.out.println("日本語表記：" + status.getDesc());

        // 全てのステータスを一覧表示
        System.out.println("---全注文状態一覧---");
        for (OrderStatus s : OrderStatus.values()) {
            System.out.println(s + " → " + s.getDesc());
        }
    }
}
