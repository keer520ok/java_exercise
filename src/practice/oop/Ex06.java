package practice.oop;

public class Ex06 {
    public static void main(String[] args) {
        // 最初の先生：佐藤 美咲
        Student 山田_明 = new Student("山田 明", 19,"佐藤 美咲");
        Student 田中_恵 = new Student("田中 恵", 20,"佐藤 美咲");

        System.out.println("---先生変更前---");
        山田_明.showInfo();
        田中_恵.showInfo();

        // 田中_恵だけ先生を鈴木 陽子に変更
        田中_恵.setTeacherName("鈴木 陽子");

        System.out.println("---先生変更後---");
        山田_明.showInfo();
        田中_恵.showInfo();
    }

    /**
     * 学生クラス
     * 属性：名前、年齢、担当先生
     */
    static class Student {
        private String name;
        private int age;
        private static String teacherName;

        public Student(String name, int age, String teacherName) {
            this.name = name;
            this.age = age;
            Student.teacherName = teacherName;

        }

        /**
         * 情報を出力
         */
        public void showInfo() {
            System.out.println("学生：" + name + "、" + age + "歳、担当先生：" + getTeacherName());
        }

        public void setTeacherName(String teacherName) {
            Student.teacherName = teacherName;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getTeacherName() {
            return teacherName;
        }
    }
}
