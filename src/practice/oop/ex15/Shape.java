package practice.oop.ex15;

/**
 * 図形インターフェース
 */
public interface Shape {
    /**
     * 周長を計算
     */
    double calcPerimeter();

    /**
     * 面積を計算
     */
    double calcArea();
}

/**
 * 長方形、Shapeインターフェースを実装
 */
class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calcPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double calcArea() {
        return width * height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

/**
 * 円、Shapeインターフェースを実装
 */
class Circle implements Shape {
    // 円周率：static final定数
    public static final double PI = Math.PI;
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calcPerimeter() {
        return PI * radius * 2;
    }

    @Override
    public double calcArea() {
        return PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
