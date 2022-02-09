package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-01-27
 */
public class Leetcode26 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return nums.length;
        }
        int l = 1;
        int r = 1;
        while (r < nums.length) {
            while (r < nums.length && nums[r] <= nums[l - 1]) {
                r++;
            }
            if (r < nums.length) {
                nums[l] = nums[r];
                l++;
            }

            r++;

        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        removeDuplicates(arr);
    }
}
