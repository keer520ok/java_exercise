package practice.oop.ex14;

/**
 * 人間クラス
 */
public class Person {
    private String name;
    private int age;
    private String gender;

    public Person() {
    }

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    /**
     * 乗り物を運転する。Vehicle型なら自転車でも車でも受け取れる
     */
    public void driveVehicle(Vehicle v) {
        System.out.println(name + " が乗り物を操作します");
        v.move();
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
