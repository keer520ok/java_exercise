package practice.oop.ex14;

/**
 * 乗り物 親クラス
 */
public class Vehicle {
    private String brand;
    private int speed;

    public Vehicle() {
    }

    public Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    /**
     * 移動する
     */
    public void move() {
        System.out.println(brand + " が時速" + speed + "kmで移動します");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

/**
 * 自転車
 */
class Bicycle extends Vehicle {
    public Bicycle() {
    }

    public Bicycle(String brand, int speed) {
        super(brand, speed);
    }

    /**
     * ベルを鳴らす
     */
    public void ringBell() {
        System.out.println("ベルがリンリンと鳴ります");
    }
}

/**
 * 自動車
 */
class Car extends Vehicle {
    public Car() {
    }

    public Car(String brand, int speed) {
        super(brand, speed);
    }

    /**
     * クラクションを鳴らす
     */
    public void honk() {
        System.out.println("クラクションがピーッと鳴ります");
    }
}