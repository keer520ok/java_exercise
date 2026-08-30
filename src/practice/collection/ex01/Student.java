package practice.collection.ex01;

/**
 * 学生情報を保持するクラス
 */
public class Student {
    // 学生ID
    private int id;
    // 氏名
    private String name;
    // 年齢
    private int age;

    /**
     * 全パラメータコンストラクタ
     *
     * @param id   学生ID
     * @param name 氏名
     * @param age  年齢
     */
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // 各フィールドのgetterメソッド
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    /**
     * 学生情報を整形した文字列で返す
     *
     * @return 「ID:xx 氏名:xx 年齢:xx」形式の文字列
     */
    @Override
    public String toString() {
        return "ID:" + id + " 氏名:" + name + " 年齢:" + age;
    }
}
