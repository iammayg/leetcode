package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-26
 */
public class Leetcode283 {
    public void moveZeroes(int[] nums) {
        int f = 0;
        int s = 0;

        while (f < nums.length) {
            if (nums[f] != 0) {
                nums[s] = nums[f];
                s++;
                f++;
            } else {
                f++;
            }
        }
        while (s < nums.length) {
            nums[s]=0;
        }
    }
}
