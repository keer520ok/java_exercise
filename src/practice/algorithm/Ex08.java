package practice.algorithm;

/**
 * 二分探索
 */
public class Ex08 {
    public static void main(String[] args) {
        // テスト用の配列（昇順）
        int[] arr = {1, 3, 5, 7, 9, 11, 13};

        // 探索する目標値
        int target = 7;

        // 二分探索を実行する
        int result = binarySearch(arr, target);

        // 結果を出力する
        if (result != -1) {
            // 見つかった場合
            System.out.println("目標値 " + target + " はインデックス " + result + " で見つかりました。");
        } else {
            // 見つからなかった場合
            System.out.println("目標値 " + target + " は見つかりませんでした。");
        }
    }

    // 二分探索
    // 配列は昇順にソートされている必要がある
    public static int binarySearch(int[] arr, int target) {
        // 配列がnull、または要素数が0の場合は見つからない
        if (arr == null || arr.length == 0) {
            return -1;
        }

        // 左端のインデックス
        int left = 0;

        // 右端のインデックス
        int right = arr.length - 1;

        while (left <= right) {
            // 中央のインデックスを計算する（オーバーフロー対策）
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                // 目標値が見つかった場合
                return mid;
            } else if (arr[mid] < target) {
                // 目標値が中央値より大きい場合、右側を探索する
                left = mid + 1;
            } else {
                // 目標値が中央値より小さい場合、左側を探索する
                right = mid - 1;
            }
        }

        // 見つからなかった場合
        return -1;
    }

}
