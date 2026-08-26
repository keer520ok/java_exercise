package practice.oop.ex15;

/**
 * 学生クラス：図形を利用する
 */
public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 図形を受け取り、情報、周長、面積を出力
     * Shape型なら長方形でも円でも受け入れ可能（ポリモーフィズム）
     */
    public void useShape(Shape shape) {
        System.out.println("===== 図形情報 =====");
        if (shape instanceof Rectangle) {
            System.out.println("長方形周長：" + shape.calcPerimeter());
            System.out.println("長方形面積：" + shape.calcArea());
        } else {
            System.out.println("円周長：" + shape.calcPerimeter());
            System.out.println("円面積：" + shape.calcArea());
        }
    }
        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }

        public int getAge () {
            return age;
        }

        public void setAge ( int age){
            this.age = age;
        }
    }

