package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-01-27
 */
public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            while (r > l && nums[r] == val) {
                r--;
            }
            while (r > l && nums[l] != val) {
                l++;
            }
            nums[l] = nums[r];
            l++;
            r--;
        }
        return r == l && nums[l] != val ? l + 1 : l;
    }

}
