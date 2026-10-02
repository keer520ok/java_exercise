package practice.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
/**
 * Mapを使用した観光スポット投票集計プログラム
 * キー：観光スポット記号、値：投票数 の構成で管理
 */
public class Ex03 {
    public static void main(String[] args) {
        // 投票管理用Map：初期状態で各観光スポットの票数を0で初期化
        Map<Character, Integer> map = new HashMap<>();
        final ThreadLocalRandom current = ThreadLocalRandom.current();
        for (int i = 0; i <= 3; i++) {
            char c = ((char) (i + 'A'));
            map.put(c, 0);
        }

        final int STUDENT_TOTAL = 80; // 学生総数
        // 80名分の投票入力処理
        for (int i = 1; i <= STUDENT_TOTAL; i++) {
            char c = (char) (current.nextInt(4) + 'A');
            map.put(c, map.get(c) + 1);
        }
        // 最多票の観光スポットを探索
        String maxAttraction = "";
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxAttraction = String.valueOf(entry.getKey());
                maxCount = entry.getValue();
            }
        }
        // 結果出力
        System.out.println("\n===== 投票集計結果 =====");
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.printf("観光スポット %s：%d 人%n", entry.getKey(), entry.getValue());
        }
        System.out.printf("%n最も希望者が多い観光スポット：%s（計 %d 人）%n", maxAttraction, maxCount);
    }
}

