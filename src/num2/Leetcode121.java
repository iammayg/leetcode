package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-14
 * 双指针
 */
public class Leetcode121 {
    public int maxProfit(int[] prices) {
        int max = 0;
        int preMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - preMin);
            preMin = Math.min(preMin, prices[i]);
        }
        return max;
    }
}
