package practice.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 「氏名,年齢」形式の文字列集合を、メソッド参照を用いてStudent型配列に変換する
 */
public class Ex08 {
    public static void main(String[] args) {
        // 元の文字列データ集合
        List<String> strList = new ArrayList<>(List.of(
                "田中太郎,20",
                "佐藤花子,19",
                "鈴木一郎,21",
                "高橋美咲,22",
                "伊藤健,20"
        ));

        // メソッド参照で文字列→Studentオブジェクトに変換し、Student型配列に格納
        Student[] studentArray = strList.stream()
                .map(Student::fromString)
                .toArray(Student[]::new);

        // 結果確認出力
        System.out.println("変換後のStudent配列：");
        for (Student stu : studentArray) {
            System.out.println(stu);
        }
    }

    /**
     * 学生情報を保持するクラス
     */
    static class Student {
        private final String name;
        private final int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        /**
         * 「氏名,年齢」形式の文字列からStudentインスタンスを生成する静的ファクトリメソッド
         *
         * @param str 「氏名,年齢」形式の文字列
         * @return 生成されたStudentオブジェクト
         */
        public static Student fromString(String str) {
            String[] parts = str.split(",");
            String name = parts[0];
            int age = Integer.parseInt(parts[1]);
            return new Student(name, age);
        }

        @Override
        public String toString() {
            return "Student{氏名='" + name + "', 年齢=" + age + "}";
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
