package practice.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 整数集合から偶数だけを抽出して結果を保存する
 */
public class Ex06 {
    public static void main(String[] args) {
        List<Integer> originList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            originList.add(i);
        }

        // Streamで偶数をフィルタし、結果を新しいListに保存
        List<Integer> evenList = originList.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("元のデータ：" + originList);
        System.out.println("偶数抽出結果：" + evenList);
    }
}
