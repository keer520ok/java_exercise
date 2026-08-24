package practice.oop;

public class Ex05 {
    public static void main(String[] args) {
        Student stu = new Student("田中", 18, 183, 60);

        // 大一：年齢+1
        stu.setAge(stu.getAge() + 1);
        stu.study();

        // 大二：体重+10kg、年齢+1
        stu.setWeight(stu.getWeight() + 10);
        stu.setAge(stu.getAge() + 1);

        // 大三：身長+2cm、体重‑3kg、年齢+1
        stu.setHeight(stu.getHeight() + 2);
        stu.setWeight(stu.getWeight() - 3);
        stu.setAge(stu.getAge() + 1);

        // 卒業、4年目なのでもう1つ年をとる
        stu.setAge(stu.getAge() + 1);

        System.out.println("大学卒業後の情報");
        stu.showInfo();
    }

    /**
     * 学生クラス
     * 属性：名前、年齢、身長、体重
     * 行動：勉強する
     */
    static class Student {
        private String name;
        private int age;
        private int height;
        private int weight;

        public Student(String name, int age, int height, int weight) {
            this.name = name;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        /**
         * 勉強する
         */
        public void study() {
            System.out.println(name + "は一生懸命勉強します。");
        }

        /**
         * 情報を出力
         */
        public void showInfo() {
            System.out.println("名前：" + name + "、年齢：" + age + "歳、身長：" + height + "cm、体重：" + weight + "kg");
        }

        // setter
        public void setAge(int age) {
            this.age = age;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        // getter
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public int getHeight() {
            return height;
        }

        public int getWeight() {
            return weight;
        }
    }
}
