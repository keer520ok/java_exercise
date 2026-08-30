package practice.collection.ex01;

import java.util.ArrayList;

public class Ex01 {
    public static void main(String[] args) {
        // 学生を格納する集合を作成
        ArrayList<Student> studentList = new ArrayList<>();

        // 学生オブジェクトを集合に追加
        studentList.add(new Student(1, "山田太郎", 20));
        studentList.add(new Student(2, "佐藤花子", 21));
        studentList.add(new Student(3, "鈴木一郎", 19));
        studentList.add(new Student(4, "田中恵子", 22));

        // 1. 集合を走査し、全学生の情報を1行ずつ出力
        for (Student student : studentList) {
            System.out.println(student);
        }

        // 2. ID検索の動作確認
        int targetId = 3;
        int index = findStudentById(studentList, targetId);
        System.out.println("\n=== ID検索結果 ===");
        if (index != -1) {
            System.out.println("ID=" + targetId + " の学生は索引 " + index + " に存在します");
            System.out.println("詳細情報：" + studentList.get(index));
        } else {
            System.out.println("ID=" + targetId + " の学生は存在しません");
        }
    }

    /**
     * IDをキーに学生を検索し、存在する場合は集合内の索引を返す
     *
     * @param list 学生の集合
     * @param id   検索対象の学生ID
     * @return 存在する場合は対応する索引、存在しない場合は-1
     */
    public static int findStudentById(ArrayList<Student> list, int id) {
        // 先頭から順にIDを比較し、一致した時点で索引を返却
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        // 最後まで一致しなければ-1を返却
        return -1;
    }

}
