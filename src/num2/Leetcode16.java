package num2;

import java.util.Arrays;

/**
 */
public class Leetcode16 {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;

        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < min) {
                    res = sum;
                    min = Math.abs(sum - target);
                }
                if (sum == target) {
                    return res;
                } else if (sum > target) {
                    r--;
                    while (r > 0 && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else {
                    l++;
                    while (l < nums.length && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
