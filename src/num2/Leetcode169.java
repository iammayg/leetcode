package num2;

public class Leetcode169 {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int r = nums[0];
        int c = 1;
        for (int i = 1; i < nums.length; i++) {
            if (r == nums[i]) {
                c++;
            } else {
                if (c == 0) {
                    r = nums[i];
                    c = 1;
                } else {
                    c--;
                }
            }
        }
        return r;
    }
}
