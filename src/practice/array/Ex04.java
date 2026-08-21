package practice.array;

/**
 * 昇順有序配列の重複要素を削除する練習
 */
public class Ex04 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3, 3, 3};

        int[] newArr = removeDuplicate(arr);
        for (int i : newArr) {
            System.out.println(i);
        }
    }

    /**
     * 昇順配列から重複を削除し、重複なしの新しい配列を返す
     *
     * @param sortedArr 昇順に並んだ配列
     * @return 重複除去後の配列
     */
    public static int[] removeDuplicate(int[] sortedArr) {
        if (sortedArr == null || sortedArr.length == 0) {
            return new int[0];
        }

        // 重複なし要素を記録するポインタ
        int uniqueCount = 0;
        int i = 1;
        while (i < sortedArr.length) {
            if (sortedArr[uniqueCount] != sortedArr[i]) {
                uniqueCount++;
                sortedArr[uniqueCount] = sortedArr[i];
            }
            i++;
        }

        // 重複分を除いた新しい配列を作成
        int[] newArr = new int[uniqueCount + 1];
        System.arraycopy(sortedArr, 0, newArr, 0, newArr.length);
        return newArr;
    }
}
