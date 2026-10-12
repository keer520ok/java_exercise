package practice.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 学生オブジェクトから氏名と年齢を「氏名-年齢」形式に整形し、配列に格納する
 * メソッド参照を使用して実装
 */
public class Ex09 {
    public static void main(String[] args) {
        // 学生オブジェクトを格納するリストを作成
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("田中太郎", 20));
        studentList.add(new Student("佐藤花子", 19));
        studentList.add(new Student("鈴木一郎", 21));
        studentList.add(new Student("高橋美咲", 22));
        studentList.add(new Student("伊藤健", 20));

        // メソッド参照で「氏名-年齢」形式の文字列を抽出し、文字列配列に変換
        String[] infoArray = studentList.stream()
                .map(Student::getFormattedInfo)
                .toArray(String[]::new);

        // 結果確認出力
        System.out.println("整形した学生情報配列：");
        for (String info : infoArray) {
            System.out.println(info);
        }
    }

    /**
     * 学生情報を保持するエンティティクラス
     */
    static class Student {
        private final String name;
        private final int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        /**
         * 氏名と年齢を「氏名-年齢」の形式に整形して返す
         *
         * @return 整形済みの学生情報文字列
         */
        public String getFormattedInfo() {
            return name + "-" + age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
