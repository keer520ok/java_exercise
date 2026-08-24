package practice.oop;

public class Ex03 {
    public static void main(String[] args) {
        Teacher t = new Teacher("田中", 38);
        t.teach();
        t.eat();
        t.sleep();
    }

    /**
     * 先生クラス
     * 属性：名前、年齢
     * 行動：授業を行う、食事する、寝る
     */
    static class Teacher {
        // 属性（フィールド）
        private String name;
        private int age;

        // コンストラクタ
        public Teacher(String name, int age) {
            this.name = name;
            this.age = age;
        }

        /**
         * 授業を行う
         */
        public void teach() {
            System.out.println(name + "は授業を行います。");
        }

        /**
         * 食事する
         */
        public void eat() {
            System.out.println(name + "はご飯を食べます。");
        }

        /**
         * 寝る
         */
        public void sleep() {
            System.out.println(name + "は寝ます。");
        }

        public String getName() {
            return this.name;
        }

        public int getAge() {
            return age;
        }
    }
}
