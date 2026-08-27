package practice.oop.ex18;

// 卓球選手
public class PingPongPlayer extends Person implements PlaySport, SpeakEnglish {
    public PingPongPlayer(String name, int age) {
        super(name, age);
    }

    @Override
    public void practice() {
        System.out.println(getName() + "は卓球を練習します");
    }

    @Override
    public void speakEnglish() {
        System.out.println(getName() + "は英語を話します");
    }
}
