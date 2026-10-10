package practice.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 氏名年齢文字列リストから24歳以上を抽出し、氏名をキー・年齢を値とするMapに格納する
 */
public class Ex07 {
    public static void main(String[] args) {
        // 元データ：氏名, 年齢 の形式の文字列リスト
        List<String> personList = new ArrayList<>();
        personList.add("tanaka, 22");
        personList.add("sato, 20");
        personList.add("suzuki, 25");
        personList.add("takahashi, 19");
        personList.add("yamamoto, 31");
        personList.add("ito, 27");

        Map<String, Integer> resultMap = personList.stream()
                .map(s -> s.split(", "))
                .filter(arr -> Integer.parseInt(arr[1]) >= 24)
                .collect(Collectors.toMap(
                        arr -> arr[0],
                        arr -> Integer.parseInt(arr[1])
                ));

        System.out.println("24歳以上抽出結果：" + resultMap);
    }
}
