package practice.oop.ex12;

/**
 * 実行クラス Ex12
 */
public class Ex12 {
    public static void main(String[] args) {
        System.out.println("===第一世代携帯===");
        Phone p1 = new Phone();
        p1.call();

        System.out.println("\n===第二世代携帯===");
        SecondPhone p2 = new SecondPhone();
        p2.call();
        p2.sendMessage();

        System.out.println("\n===第三世代携帯===");
        ThirdPhone p3 = new ThirdPhone();
        p3.call();
        p3.sendMessage();
        p3.playGame();
    }
}
