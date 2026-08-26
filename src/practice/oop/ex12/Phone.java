package practice.oop.ex12;

/**
 * 第一世代携帯電話
 */
public class Phone {
    /**
     * 電話をかける
     */
    public void call() {
        System.out.println("音声通話を行います");
    }
}

/**
 * 第二世代携帯電話
 */
class SecondPhone extends Phone {

    /**
     * メッセージを送信する
     */
    public void sendMessage() {
        System.out.println("SMSメッセージを送信します");
    }
}

/**
 * 第三世代携帯電話
 */
class ThirdPhone extends SecondPhone {

    /**
     * 電話機能を上書き：ビデオ通話
     */
    @Override
    public void call() {
        System.out.println("ビデオ通話を行います");
    }

    /**
     * ゲームをプレイする
     */
    public void playGame() {
        System.out.println("ゲームをプレイします");
    }
}


