package practice.oop.ex11;

/**
 * スマートホン
 */
public class Smartphone extends ElectronicDevice {
    public Smartphone() {
    }

    public Smartphone(String brand, double price) {
        super(brand, price);
    }

    public void call() {
        System.out.println(getBrand() + "が電話をかけます");
    }

    public void sendMessage() {
        System.out.println(getBrand() + "がメッセージを送信します");
    }
}

class AndroidPhone extends Smartphone {
    public AndroidPhone() {
    }

    public AndroidPhone(String brand, double price) {
        super(brand, price);
    }

    public void useNfc() {
        System.out.println(getBrand() + "のNFC機能を起動します");
    }
}

class IPhone extends Smartphone {
    public IPhone() {
    }

    public IPhone(String brand, double price) {
        super(brand, price);
    }
}