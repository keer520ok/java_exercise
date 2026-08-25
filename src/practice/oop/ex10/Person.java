package practice.oop.ex10;

/**
 * 人 親クラス
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
     * 食事する
     */
    public void eat() {
        System.out.println(name + "がご飯を食べます");
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

/**
 * 学生 子クラス
 */
class Student extends Person {
    private String grade;

    public Student() {
    }

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    /**
     * 勉強する
     */
    public void study() {
        System.out.println(getName() + "が勉強します");
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

/**
 * 先生 子クラス
 */
class Teacher extends Person {
    private String subject;

    public Teacher() {
    }

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    /**
     * 授業を教える
     */
    public void teach() {
        System.out.println(getName() + "が" + subject + "を教えます");
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
