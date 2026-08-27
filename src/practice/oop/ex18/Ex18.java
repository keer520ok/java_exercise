package practice.oop.ex18;

/**
 * 実行クラス Ex18
 */
public class Ex18 {
    public static void main(String[] args) {
        PingPongPlayer p1 = new PingPongPlayer("田中", 22);
        p1.practice();
        p1.speakEnglish();

        BasketballPlayer p2 = new BasketballPlayer("佐藤", 20);
        p2.practice();

        PingPongCoach c1 = new PingPongCoach("鈴木", 40);
        c1.teach();
        c1.speakEnglish();

        BasketballCoach c2 = new BasketballCoach("高橋", 45);
        c2.teach();
    }
}
