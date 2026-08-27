package practice.oop.ex17;

/**
 * 実行クラス Ex17
 */
public class Ex17 {
    public static void main(String[] args) {
        Frog frog = new Frog("ケロちゃん", "緑色");
        frog.eat();
        frog.swim();

        System.out.println("----------");

        Dog dog = new Dog("ポチ", "茶色");
        dog.eat();
        dog.swim();

        System.out.println("----------");

        Rabbit rabbit = new Rabbit("ミミ", "白");
        rabbit.eat();
    }
}
