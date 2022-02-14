package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-14
 * 双指针
 */
public class Leetcode53 {
    /**
     * 做法：如何将所有情况都枚举到
     * 优化：考虑单调性
     */
    public int maxSubArray(int[] nums) {
        int[] max = new int[nums.length];
        max[0] = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(nums[i], nums[i] + max[i - 1]);
            maxSum = Math.max(maxSum, max[i]);
        }
        return maxSum;
    }
}
