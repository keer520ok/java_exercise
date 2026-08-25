package practice.oop.ex11;
/**
 * 実行クラス Ex11
 */
public class Ex11 {
    public static void main(String[] args) {
        AndroidPhone android = new AndroidPhone("Xiaomi", 3999);
        android.call();
        android.sendMessage();
        android.useNfc();

        IPhone iphone = new IPhone("Apple", 5999);
        iphone.call();
        iphone.sendMessage();

        Laptop pc = new Laptop("Lenovo", 4500);
        pc.coding();
    }
}
