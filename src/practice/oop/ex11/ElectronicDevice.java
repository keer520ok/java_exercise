package practice.oop.ex11;

/**
 * 電子機器 親クラス
 */
public class ElectronicDevice {
    private String brand;
    private double price;

    public ElectronicDevice() {
    }

    public ElectronicDevice(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
