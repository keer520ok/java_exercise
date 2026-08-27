package practice.oop.ex17;

/**
 * 動物親クラス
 */
public class Animal {
    private String name;
    private String color;

    public Animal() {
    }

    public Animal(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void eat() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

/**
 * カエルクラス
 */
class Frog extends Animal implements CanSwim {

    public Frog() {
    }

    public Frog(String name, String color) {
        super(name, color);
    }

    @Override
    public void eat() {
        System.out.println(getColor() + "のカエル【" + getName() + "】が虫を食べます");
    }

    /**
     * 蛙泳
     */
    @Override
    public void swim() {
        System.out.println(getName() + "が蛙泳で泳いでいます");
    }

}

/**
 * 犬クラス
 */
class Dog extends Animal implements CanSwim {
    public Dog() {
    }

    public Dog(String name, String color) {
        super(name, color);
    }

    @Override
    public void eat() {
        System.out.println(getColor() + "の犬【" + getName() + "】が骨を食べます");
    }

    /**
     * 犬かき
     */
    @Override
    public void swim() {
        System.out.println(getName() + "が犬かきで泳いでいます");
    }
}

/**
 * ウサギクラス
 */
class Rabbit extends Animal {
    public Rabbit() {
    }

    public Rabbit(String name, String color) {
        super(name, color);
    }

    @Override
    public void eat() {
        System.out.println(getColor() + "のウサギ【" + getName() + "】がニンジンを食べます");
    }
}