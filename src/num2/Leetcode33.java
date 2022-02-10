package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-09
 */
public class Leetcode33 {

    /**
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     */
    public static int search(int[] nums, int target) {
        int x = nums[0];
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] >= x) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        if (target >= x) {
            l = 0;
        } else {
            r = nums.length - 1;
            l = l+1 == nums.length ? 0 : l + 1;
        }
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return nums[l] == target ? l : -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
    }
}
