package practice.oop.ex13;

/**
 * 実行クラス Ex13
 */
public class Ex13 {
    public static void main(String[] args) {
        Phone phone = new Phone("スマホA", 6000);
        System.out.println(phone.getProductName() + "\t\t販売価格：" + phone.calcSalePrice());

        Laptop laptop = new Laptop("ノートPCB", 6000);
        System.out.println(laptop.getProductName() + "\t販売価格：" + laptop.calcSalePrice());

        Tablet tablet = new Tablet("タブレットC", 11000);
        System.out.printf("%s\t販売価格：%.1f", tablet.getProductName(), tablet.calcSalePrice());
    }
}
