package practice.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 指定したフォルダ配下から .txt ファイルを再帰的に検索する
 * サブフォルダもすべて探索対象とする
 */
public class Ex04 {
    public static void main(String[] args) {
        // 検索を開始するルートフォルダを指定
        String rootPath = "./"; // 必要に応じて実際のパスに変更
        File rootDir = new File(rootPath);

        if (!rootDir.exists() || !rootDir.isDirectory()) {
            System.out.println("指定されたパスは存在しないか、ディレクトリではありません：" + rootPath);
            return;
        }

        List<File> txtFiles = new ArrayList<>();
        searchTxtFiles(rootDir, txtFiles);

        System.out.println("txtファイルが見つかりました：");
        for (File file : txtFiles) {
            System.out.println(file.getAbsolutePath());
        }
    }

    /**
     * ディレクトリを再帰的に探索し、.txt ファイルをリストに追加する
     *
     * @param dir    探索開始ディレクトリ
     * @param result 発見したtxtファイルを格納するリスト
     */
    private static void searchTxtFiles(File dir, List<File> result) {
        File[] items = dir.listFiles();
        if (items == null) {
            return; // 権限エラーなどで一覧取得できない場合はスキップ
        }

        for (File item : items) {
            if (item.isDirectory()) {
                // サブディレクトリの場合は再帰的に探索
                searchTxtFiles(item, result);
            } else if (item.isFile()
                    && item.getName().toLowerCase().endsWith(".txt")) {
                // .txt で終わるファイルのみリストに追加
                result.add(item);
            }
        }
    }
}
