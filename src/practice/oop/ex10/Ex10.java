package practice.oop.ex10;

/**
 * 実行クラス Ex10
 */
public class Ex10 {
    public static void main(String[] args) {
        Student s = new Student("田中", 18, "高校2年");
        s.eat();
        s.study();

        Teacher t = new Teacher("佐藤", 35, "数学");
        t.eat();
        t.teach();
    }
}
