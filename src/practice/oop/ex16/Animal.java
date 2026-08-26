package practice.oop.ex16;

/**
 * 動物 親クラス
 */
public class Animal {
    private int age;
    private String color;

    public Animal() {
    }

    public Animal(int age, String color) {
        this.age = age;
        this.color = color;
    }

    /**
     * 食べるメソッド
     */
    public void eat(String something) {
        System.out.println(something + " を食べます");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

/**
 * 犬クラス
 */
class Dog extends Animal {
    public Dog() {
    }

    public Dog(int age, String color) {
        super(age, color);
    }

    @Override
    public void eat(String something) {
        System.out.println(getAge() + "歳の" + getColor() + "の犬が " + something + " を食べています");
    }

    /**
     * 犬固有：家を守る
     */
    public void lookHome() {
        System.out.println("犬が家を警戒して守っています");
    }
}

/**
 * 猫クラス
 */
class Cat extends Animal {
    public Cat() {
    }

    public Cat(int age, String color) {
        super(age, color);
    }

    @Override
    public void eat(String something) {
        System.out.println(getAge() + "歳の" + getColor() + "の猫が " + something + " を食べています");
    }

    /**
     * 猫固有：ネズミ捕り
     */
    public void catchMouse() {
        System.out.println("猫がネズミを捕まえました");
    }
}
