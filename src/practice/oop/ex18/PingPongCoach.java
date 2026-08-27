package practice.oop.ex18;

// 卓球コーチ
public class PingPongCoach extends Person implements TeachSport, SpeakEnglish {
    public PingPongCoach(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println(getName() + "は卓球を教えます");
    }

    @Override
    public void speakEnglish() {
        System.out.println(getName() + "は英語を話します");
    }
}