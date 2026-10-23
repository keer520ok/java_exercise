package practice.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ディレクトリを丸ごとコピーする
 * サブディレクトリを含む全階層のファイルを再帰的に複製する
 */
public class Ex01 {
    /**
     * ディレクトリ全体をコピーする（ソースディレクトリごとコピー先に格納）
     *
     * @param src  コピー元ディレクトリ
     * @param dest コピー先の親ディレクトリ
     * @throws IllegalArgumentException 引数が不正な場合
     * @throws RuntimeException         コピー処理中にIOエラーが発生した場合
     */
    private static void copyDirectory(File src, File dest) {
        // 引数のnullチェック
        if (src == null || dest == null) {
            throw new IllegalArgumentException("引数にnullが指定されました");
        }
        // コピー元がディレクトリであることを確認
        if (!src.isDirectory()) {
            throw new IllegalArgumentException("コピー元がディレクトリではありません: " + src.getPath());
        }

        try {
            // コピー先にソースと同名のディレクトリを作成
            File destDir = new File(dest, src.getName());
            copyDirectoryRecursive(src, destDir);
        } catch (IOException e) {
            throw new RuntimeException("ディレクトリコピー処理中にエラーが発生しました", e);
        }
    }

    /**
     * ディレクトリ内を再帰的に走査してコピーする
     *
     * @param src  コピー元ディレクトリ
     * @param dest コピー先ディレクトリ
     * @throws IOException ディレクトリ作成・ファイル読み込みでエラーが発生した場合
     */
    private static void copyDirectoryRecursive(File src, File dest) throws IOException {
        // コピー先ディレクトリが存在しない場合は多段階で作成
        if (!dest.exists()) {
            if (!dest.mkdirs()) {
                throw new IOException("コピー先ディレクトリの作成に失敗しました: " + dest.getPath());
            }
        }

        File[] srcFiles = src.listFiles();
        // ディレクトリ内の一覧が取得できない場合
        if (srcFiles == null) {
            throw new IOException("コピー元ディレクトリの読み込みに失敗しました: " + src.getPath());
        }

        for (File srcFile : srcFiles) {
            File destFile = new File(dest, srcFile.getName());
            if (srcFile.isFile()) {
                // ファイルの場合は単体コピーを実行
                copyFile(srcFile, destFile);
            } else if (srcFile.isDirectory()) {
                // ディレクトリの場合は再帰的にコピー
                copyDirectoryRecursive(srcFile, destFile);
            }
        }
    }

    /**
     * 単一ファイルをバッファ付きで高速コピーする
     *
     * @param src  コピー元ファイル
     * @param dest コピー先ファイル
     * @throws IOException ファイルの読み書きでエラーが発生した場合
     */
    private static void copyFile(File src, File dest) throws IOException {
        // 8KB バッファで一括読み書きし、システムコール回数を削減
        byte[] buffer = new byte[1024 * 8];

        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)) {

            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        }
    }
}
