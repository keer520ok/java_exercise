package practice.oop.ex18;

// 親クラス
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

// スポーツを練習する能力
interface PlaySport {
    void practice();
}

// スポーツを教える能力
interface TeachSport {
    void teach();
}

// 英語を話す能力
interface SpeakEnglish {
    void speakEnglish();
}