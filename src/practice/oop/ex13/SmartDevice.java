package practice.oop.ex13;

public class SmartDevice {
    /**
     * スマートデバイス 親クラス
     */
    private String productName;
    private double originalPrice;

    public SmartDevice() {
    }

    public SmartDevice(String productName, double originalPrice) {
        this.productName = productName;
        this.originalPrice = originalPrice;
    }

    /**
     * 割引後販売価格を計算する
     */
    public double calcSalePrice() {
        double price = getOriginalPrice();
        if (price < 1000) {
            return price;
        } else if (price < 5000) {
            return price * 0.9;
        } else if (price < 10000) {
            return price * 0.8;
        } else {
            return price * 0.7;
        }
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }
}

/**
 * 携帯電話：追加補助割引あり
 */
class Phone extends SmartDevice {
    public Phone() {
    }

    public Phone(String productName, double originalPrice) {
        super(productName, originalPrice);
    }

    /**
     * 親の割引計算の後、さらに補助金で0.9倍
     */
    @Override
    public double calcSalePrice() {
        double basePrice = super.calcSalePrice();
        return basePrice * 0.9;
    }
}

/**
 * ノートPC 追加割引なし
 */
class Laptop extends SmartDevice {
    public Laptop() {
    }

    public Laptop(String productName, double originalPrice) {
        super(productName, originalPrice);
    }
}

/**
 * タブレット 追加割引なし
 */
class Tablet extends SmartDevice {
    public Tablet() {
    }

    public Tablet(String productName, double originalPrice) {
        super(productName, originalPrice);
    }
}