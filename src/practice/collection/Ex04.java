package practice.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 都道府県をキー、複数の都市を値とする1対多Map
 * 値はList<String>で複数の都市を管理する
 */
public class Ex04 {
    public static void main(String[] args) {
// キー：都道府県名、値：都市リスト のMapを作成
        Map<String, List<String>> prefectureMap = new HashMap<>();

        // 神奈川県の主要都市を追加
        List<String> kanagawa = new ArrayList<>();
        kanagawa.add("横浜市");
        kanagawa.add("川崎市");
        kanagawa.add("相模原市");
        kanagawa.add("横須賀市");
        kanagawa.add("茅ヶ崎市");
        prefectureMap.put("神奈川県", kanagawa);

        // 大阪府の主要都市を追加
        List<String> osaka = new ArrayList<>();
        osaka.add("大阪市");
        osaka.add("堺市");
        osaka.add("東大阪市");
        osaka.add("豊中市");
        osaka.add("吹田市");
        prefectureMap.put("大阪府", osaka);

        // 北海道の主要都市を追加
        List<String> hokkaido = new ArrayList<>();
        hokkaido.add("札幌市");
        hokkaido.add("旭川市");
        hokkaido.add("函館市");
        hokkaido.add("釧路市");
        hokkaido.add("帯広市");
        prefectureMap.put("北海道", hokkaido);

        // 指定書式で走査して出力
        for (Map.Entry<String, List<String>> entry : prefectureMap.entrySet()) {
            String prefName = entry.getKey();
            List<String> cityList = entry.getValue();
            // 都市リストを「、」で結合して出力書式に整形
            String cities = String.join("、", cityList);
            System.out.println(prefName + " = " + cities);
        }
    }
}
