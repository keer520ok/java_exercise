package practice.basic;

/**
 * 問題：残高計算
 * 微信残高：0元
 * 支付宝残高：10元
 * 銀行カード残高：20元
 * 質問1：全て合わせるといくらになるか？
 * 質問2：微信が10元の赤い封筒を受け取り、2元の赤い封筒を送った後の残高はいくらか？
 */
public class ex01 {
    public static void main(String[] args) {
        // 各口座残高
        double wechat = 0;
        double alipay = 10;
        double bankCard = 20;

        // 問題1：合計金額
        double total = addAll(wechat, alipay, bankCard);
        System.out.println("合計金額：" + total);

        // 問題2：微信残高更新
        double newWechat = addAll(wechat,10,-2);
        System.out.println("更新後の微信残高：" + newWechat);
    }

    /**
     * 可変引数による合計計算
     * @param nums 計算対象の数値
     * @return 合計値
     */
    public static double addAll(double... nums) {
        double sum = 0;
        for (double num : nums) {
            sum += num;
        }
        return sum;
    }
}
