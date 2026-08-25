package practice.oop.ex11;

/**
 * ノートパソコン
 */
public class Laptop extends ElectronicDevice {
    public Laptop() {
    }

    public Laptop(String brand, double price) {
        super(brand, price);
    }

    /**
     * プログラミングを行う
     */
    public void coding() {
        System.out.println(getBrand() + "でプログラミングを行います");
    }
}
