package game.ui;


import game.entity.Enemy;
import game.entity.GameCharacter;
import game.entity.Hero;
import game.enums.AttributeType;
import game.enums.SkillPool;
import game.util.ConsoleUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class GameSystem {
    private static final AttributeType[] ATTR_TYPES = AttributeType.getAll();
    private final Scanner sc = new Scanner(System.in);
    private final ThreadLocalRandom tlr = ThreadLocalRandom.current();


    public void gameStart(String username) {
        ConsoleUtil.printLine();
        String title = "🎮 文字格闘ゲームへようこそ 🎮";
        ConsoleUtil.printCentered(title);
        ConsoleUtil.printLine();

        System.out.println("\nキャラクターを作成：");
        System.out.println("キャラクター名：" + username);
        System.out.println();

        Hero player = createHeroByAssign(username);
        System.out.println("-".repeat(30));

        System.out.println("\nキャラクター作成完了！");
        System.out.println("🌟 初期ステータス：" + player);
        System.out.print("🌟 所持スキル：");

        List<SkillPool> skills = player.getSkills();
        for (int i = 0; i < skills.size(); i++) {
            if (i > 0) {
                System.out.print("，");
            }
            String skillName = skills.get(i).getSkillName();
            System.out.print(skillName);
        }
        System.out.println();

        ArrayList<Enemy> enemyList = new ArrayList<>();
        enemyList.add(new Enemy.EnemyBuilder()
                // 基本情報
                .setName("ゴブリン")
                // 戦闘基礎ステータス
                .setBaseHp(80)
                .setBaseAtk(15)
                .setBaseDef(10)
                // スキル
                .setSkillList(List.of(SkillPool.POISON, SkillPool.ENRAGE, SkillPool.IRON_WALL))
                .build());

        int battleCount = 1;
        int winCount = 0;
        battleLoop:
        while (player.isAlive()) {
            // ランダムで敵を選択して成長適用
            int targetIndex = tlr.nextInt(enemyList.size());
            Enemy enemy = enemyList.get(targetIndex);
            enemy.applyBattleGrowth(winCount);


            System.out.printf("%n▶ ⚔️第%d戦目の戦闘開始！ ◀%n", battleCount);
            System.out.println("プレイヤー：" + player);
            System.out.println("敵：" + enemy);
            System.out.println("-".repeat(50));

            // 単場戦闘を実行、勝敗を受け取る
            boolean playerWin = executeSingleBattle(player, enemy);
            // 戦後決済
            if (playerWin) {
                winCount++;
                int amount = tlr.nextInt(21) + 20;
                player.heal(amount);

                System.out.printf("🎉 %sを倒した！勝利！%n", enemy.getName());
                System.out.printf("💚 HPを%d回復した%n", amount);
                System.out.printf("🏆 現在の勝利数：%d%n", winCount);
                System.out.println("=".repeat(30));
            } else {
                System.out.println("💀 あなたは倒れた…敗北");
                break;
            }
            if (winCount > 0 && winCount % 3 == 0) {
                player.applyBattleGrowth(winCount);
                System.out.println("💎 ステータスが上昇！");
                for (AttributeType attrType : ATTR_TYPES) {
                    System.out.printf("%sが%dポイント上昇%n",
                            attrType.getName(), attrType.getGrowthPer3Wins());
                }
                System.out.println("現在のステータス：" + player);
            }


            final String optContinue = "1";
            final String optQuit = "2";
            inputLoop:
            while (true) {
                System.out.println("\n戦闘を続けますか?");
                System.out.println("1.続行");
                System.out.println("2.放棄");
                String input = ConsoleUtil.normalizeInput(sc.nextLine());
                switch (input) {
                    case optContinue -> {
                        battleCount++;
                        break inputLoop;
                    }
                    case optQuit -> {
                        break battleLoop;
                    }
                    default -> {
                        System.out.println("入力に誤りがあります。再入力してください");

                    }
                }
            }
        }
        ConsoleUtil.printLine();
        System.out.printf("\nゲーム終了%n" +
                "総勝利数：%d%n" +
                "プレイありがとう！", winCount);
    }

    /**
     * 単一戦闘を実行する
     * プレイヤーまたは敵のいずれかのHPが0になるまでターンを繰り返す
     *
     * @param player プレイヤーキャラクター
     * @param enemy  敵キャラクター
     * @return boolean プレイヤーが生存していればtrue（勝利）、敗北ならfalse
     */
    private boolean executeSingleBattle(Hero player, Enemy enemy) {
        int round = 1;
        while (player.isAlive() && enemy.isAlive()) {
            System.out.printf("===== ⚔️第%dターン=====%n", round);
            turnBattleStart(player, enemy);
            round++;
            System.out.println("-".repeat(50));
            System.out.println();
        }
        return player.isAlive();
    }

    /**
     * 1ターン分の戦闘処理を実行する
     * プレイヤーの行動→敵の行動の順で処理を実行
     *
     * @param player プレイヤーキャラクター
     * @param enemy  敵キャラクター
     */
    private void turnBattleStart(Hero player, Enemy enemy) {
        showHpBar(player);
        showHpBar(enemy);

        SkillPool selected;
        String result;
        while (true) {
            System.out.println("\n===== あなたのターン ===== ");
            // ユーザー入力からスキルを選択
            player.printSkillMenu();
            while (true) {
                if (!sc.hasNextInt()) {
                    System.out.println("数字を入力してください！");
                    sc.next();
                } else break;
            }
            int menuId = sc.nextInt();
            sc.nextLine();
            selected = SkillPool.fromCode(menuId);
            if (selected == null || !player.getSkills().contains(selected)) {
                System.out.println("無効な番号 ");
                continue;
            }
            result = player.useSkill(selected, enemy);
            if (result == null) {
                System.out.println("HPが足りず、スキルが発動できない！");
                continue;
            }
            break;
        }
        System.out.println(result);
        if (!enemy.isAlive()) return;

        // ===== 敵ターン =====
        System.out.println("===== 敵ターン =====");
        String result2 = enemy.autoUseSkill(player);
        System.out.println(result2);
        if (!player.isAlive()) return;
        // ===== ターン終了：バフ残り時間減少 =====
        player.tickBuff();
        enemy.tickBuff();
    }

    /**
     * キャラクターのHPバーをコンソールに表示する
     *
     * @param gameCharacter 対象のキャラクターインスタンス
     */
    private static void showHpBar(GameCharacter gameCharacter) {
        // HPバーの埋まっている部分のアイコン
        final String ICON_FILL = "█";
        // HPバーの空いている部分のアイコン
        final String ICON_EMPTY = "░";
        // HPバー全体の文字数
        final int BAR_TOTAL_LENGTH = 20;

        int currentHp = gameCharacter.getHp();     // 現在HP
        int maxHp = gameCharacter.getMaxHP();      // 最大HP

        // HP割合から描画する埋めアイコン数を算出（切り上げ）
        int ceil = (int) Math.ceil((double) currentHp / maxHp * BAR_TOTAL_LENGTH);
        String filled = ICON_FILL.repeat(ceil);
        String blank = ICON_EMPTY.repeat(BAR_TOTAL_LENGTH - ceil);

        // HPバー本体を出力
        System.out.println("【" + filled + blank + "】");
        // キャラクター名とHP数値を出力
        System.out.printf("%s HP：%d/%d%n",
                gameCharacter.getName(), currentHp, maxHp);
    }

    /**
     * ヒーローを作成し、ユーザーにステータスポイントを割り当てさせる
     *
     * @param username ユーザー名
     * @return 割当完了後のHeroインスタンス
     */
    private Hero createHeroByAssign(String username) {
        // 割り当て可能な最大ポイント
        final int assignMaxPoint = 20;
        // 各属性に割り当てた属性ポイントを保持する配列
        final int[] assignedAttrPoints = new int[ATTR_TYPES.length];
        // 残り割当ポイント
        int point = assignMaxPoint;

        System.out.printf("キャラクタ基礎HP：%d、基礎攻撃：%d、基礎防御：%d%n"
                , Hero.BASE_HP, Hero.BASE_ATK, Hero.BASE_DEF);
        while (true) {
            System.out.printf("属性を選択してください。残り割当ポイント：%d%n", point);
            for (AttributeType attrType : ATTR_TYPES) {
                System.out.printf("%d:%s(1ポイントあたり+%d)%n",
                        attrType.getMenuId(), attrType.getName(), attrType.getPerPoint());
            }

            if (!sc.hasNextInt()) {
                System.out.println("入力が無効");
                sc.next();
                continue;
            }
            int choice = sc.nextInt();
            sc.nextLine();
            AttributeType byMenuId = AttributeType.getByMenuId(choice);


            if (byMenuId == null) {
                System.out.println("入力が無効です。再選択してください。");
                continue;
            } else {
                // 属性にポイントを割り当て、消費したポイント数を取得
                int consumedPoint = assignPoint(byMenuId, point, assignedAttrPoints);
                point -= consumedPoint;
                System.out.println("割り当て成功");
            }
            System.out.println(Arrays.toString(assignedAttrPoints));
            // ポイントを全て使い切った場合
            if (point == 0) {
                AttributeType hp = AttributeType.HP;
                AttributeType atk = AttributeType.ATTACK;
                AttributeType defense = AttributeType.DEFENSE;
                int hpAssignPoint = assignedAttrPoints[hp.getIndex()];
                int atkAssignPoint = assignedAttrPoints[atk.getIndex()];
                int defAssignPoint = assignedAttrPoints[defense.getIndex()];
                // HP属性ポイント × 1ポイントあたりの上昇値
                int hpBonusValue = hpAssignPoint * hp.getPerPoint();
                // 攻撃属性ポイント × 1ポイントあたりの上昇値
                int atkBonusValue = atkAssignPoint * atk.getPerPoint();
                // 防御属性ポイント × 1ポイントあたりの上昇値
                int defBonusValue = defAssignPoint * defense.getPerPoint();
                System.out.printf("%n割当完了。%n" +
                                "割当回数：%n" +
                                "HP%d回（+%dHP）%n" +
                                "攻撃%d回（+%dATK）%n" +
                                "防御%d回（+%dDEF）%n",
                        hpAssignPoint, hpBonusValue, atkAssignPoint, atkBonusValue, defAssignPoint, defBonusValue);

                boolean flag = false;
                // 確認入力待ちループ
                while (!flag) {
                    System.out.println("\n確認しますか？");
                    System.out.println("Y：割当確定　N：割当を最初からやり直し");
                    String r = ConsoleUtil.normalizeInput(sc.next());
                    sc.nextLine();
                    switch (r) {
                        case "Y": {
                            int finalHp = Hero.calcFinalStat(hp, hpBonusValue);
                            int finalAtk = Hero.calcFinalStat(atk, atkBonusValue);
                            int finalDefense = Hero.calcFinalStat(defense, defBonusValue);
                            return new Hero(username, finalHp, finalAtk, finalDefense);
                        }
                        case "N":
                            // 配列を初期化、ポイントを最大値に戻し再割当へ
                            Arrays.fill(assignedAttrPoints, 0);
                            point = assignMaxPoint;
                            flag = true;
                            break;
                        default:
                            System.out.println("入力が無効です！");
                    }
                }
            }
        }
    }

    /**
     * ステータスに属性ポイントを割り当てる
     * ユーザーから入力値を受け取り、入力値の範囲を補正した後、ステータス配列へ反映する
     *
     * @param byMenuId     割当対象の属性種別
     * @param point        割当可能な残りポイント
     * @param assignedAttrPoints 各属性に割り当てたポイントを保持する配列
     * @return int 実際に消費したポイント数
     */
    private int assignPoint(AttributeType byMenuId, int point, int[] assignedAttrPoints) {
        System.out.printf("%sの属性ポイントを割り当ててください（合計%dポイント）：", byMenuId.getName(), point);
        while (true) {
            if (!sc.hasNextInt()) {
                System.out.println("数字を入力してください！");
                sc.next();
            } else break;
        }

        int consumedPoint = sc.nextInt();
        sc.nextLine();
        if (consumedPoint < 0) {
            System.out.println("0ポイント割り当て");
            consumedPoint = 0;
        } else if (consumedPoint > point) {
            System.out.println("全ポイント割り当て");
            consumedPoint = point;
        }
        assignedAttrPoints[byMenuId.getIndex()] += consumedPoint;
        return consumedPoint;
    }

}