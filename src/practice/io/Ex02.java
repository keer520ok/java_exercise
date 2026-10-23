package practice.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * バイト単位のファイル暗号化・復号化プログラム
 * XOR演算による簡易対称暗号方式を実装
 */
public class Ex02 {
    // 暗号化に使用する鍵値（0～255の範囲で任意に変更可）
    private static final byte ENCRYPT_KEY = 0x5A;

    public static void main(String[] args) {
        String originalFile = "./original.txt";
        String encryptedFile = "./encrypted.dat";
        String decryptedFile = "./decrypted.txt";

        try {
            // 暗号化実行
            encryptFile(originalFile, encryptedFile);
            System.out.println("暗号化完了：" + encryptedFile);

            // 復号化実行
            decryptFile(encryptedFile, decryptedFile);
            System.out.println("復号化完了：" + decryptedFile);

        } catch (IOException e) {
            System.out.println("ファイル処理中にエラーが発生しました：" + e.getMessage());
        }
    }

    /**
     * ファイルを暗号化する
     *
     * @param sourcePath 元ファイルのパス
     * @param destPath   暗号化済みファイルの出力先パス
     * @throws IOException ファイル読み書きエラー
     */
    private static void encryptFile(String sourcePath, String destPath) throws IOException {
        processFile(sourcePath, destPath, ENCRYPT_KEY);
    }

    /**
     * 暗号化済みファイルを復号化する
     *
     * @param sourcePath 暗号化済みファイルのパス
     * @param destPath   復号化後ファイルの出力先パス
     * @throws IOException ファイル読み書きエラー
     */
    private static void decryptFile(String sourcePath, String destPath) throws IOException {
        // XOR暗号は同じ鍵で再度演算すると元に戻るため、暗号化と同じ処理で復号化
        processFile(sourcePath, destPath, ENCRYPT_KEY);
    }

    /**
     * ファイルの全バイトに鍵値でXOR演算を実行する共通処理
     *
     * @param sourcePath 入力元ファイルパス
     * @param destPath   出力先ファイルパス
     * @param key        演算に使用する鍵バイト
     * @throws IOException ファイル読み書きエラー
     */
    private static void processFile(String sourcePath, String destPath, byte key) throws IOException {
        byte[] buffer = new byte[8192]; // 8KBバッファで効率化

        // try-with-resourcesでストリームを自動的に解放
        try (FileInputStream fis = new FileInputStream(sourcePath);
             FileOutputStream fos = new FileOutputStream(destPath)) {

            int readLen;
            // バッファ単位で読み込み
            while ((readLen = fis.read(buffer)) != -1) {
                // 読み込んだ分の各バイトにXOR演算を実行
                for (int i = 0; i < readLen; i++) {
                    buffer[i] = (byte) (buffer[i] ^ key);
                }
                // 演算済みデータを書き出し
                fos.write(buffer, 0, readLen);
            }
        }
    }
}
