package game;


import game.ui.GameSystem;
import game.ui.UserSystem;
import game.user.User;

public class App {
    public static void main(String[] args) {
        UserSystem userSystem = new UserSystem();
        User loginUser = userSystem.start();
        // ログイン成功したらゲーム開始
        if (loginUser != null) {
            GameSystem gameSystem = new GameSystem();
            gameSystem.gameStart(loginUser.getUsername());
        }
        System.out.println("プログラムを終了します");
        System.exit(0);
    }
}

