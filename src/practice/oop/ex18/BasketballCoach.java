package practice.oop.ex18;

// バスケコーチ
public class BasketballCoach extends Person implements TeachSport {
    public BasketballCoach(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println(getName() + "はバスケットボールを教えます");
    }
}