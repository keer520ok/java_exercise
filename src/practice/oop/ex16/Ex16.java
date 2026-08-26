package practice.oop.ex16;

/**
 * 実行クラス Ex16
 */
public class Ex16 {
    public static void main(String[] args) {
        Person keeper = new Person("佐藤", 30);

        //犬を飼育
        Animal dog = new Dog(2, "黒色");
        keeper.keepPet(dog, "肉");

        System.out.println("----------------");

        //猫を飼育
        Animal cat = new Cat(1, "白");
        keeper.keepPet(cat, "魚");
    }
}
