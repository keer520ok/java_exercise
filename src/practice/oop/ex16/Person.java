package practice.oop.ex16;

/**
 * 飼育員 Personクラス
 */
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 動物を飼育する。Animal親型で犬猫両方受け取り
     * instanceofで型判定、ダウンキャストしてサブクラス固有メソッド実行
     */
    public void keepPet(Animal animal, String something) {
        System.out.println("飼育員【" + name + "】が餌やりを開始");
        animal.eat(something);

        // ダウンキャスト：実際のインスタンス型を確認
        if (animal instanceof Dog dog) {
            dog.lookHome();
        } else if (animal instanceof Cat cat) {
            cat.catchMouse();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}