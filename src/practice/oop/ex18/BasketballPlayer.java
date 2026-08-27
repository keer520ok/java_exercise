package practice.oop.ex18;

// バスケ選手
public class BasketballPlayer extends Person implements PlaySport {
    public BasketballPlayer(String name, int age) {
        super(name, age);
    }

    @Override
    public void practice() {
        System.out.println(getName() + "はバスケットボールを練習します");
    }
}