package practice.oop.ex15;

/**
 * 実行クラス Ex15
 */
public class Ex15 {

    public static void main(String[] args) {
        Student stu = new Student("山田", 20);

        //長方形 幅4、高さ3
        Rectangle rect = new Rectangle(4, 3);
        stu.useShape(rect);

        //円 半径2
        Circle circle = new Circle(2);
        stu.useShape(circle);
    }
}
