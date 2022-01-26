package num2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 */
public class Leetcode15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int curNum = nums[i] + nums[l] + nums[r];
                if (curNum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    while (l < nums.length && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    r--;
                    while (r > 0 && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if (curNum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0, 0, 0, 0};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }
}
