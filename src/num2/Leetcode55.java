package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-23
 */
public class Leetcode55 {
    public static boolean canJump(int[] nums) {
        if (nums[0] == 0) {
            if (nums.length == 1) {
                return true;
            }
            return false;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length && max >= i; i++) {
            max = Math.max(max, i + nums[i]);
        }
        return max > nums.length - 1;
    }


    //    public static boolean canJump(int[] nums) {
    //        return dfs(nums, 0);
    //    }
    //
    //    static boolean dfs(int[] nums, int p) {
    //        if (p >= nums.length - 1) {
    //            return true;
    //        }
    //        if (nums[p] == 0) {
    //            return false;
    //        }
    //        ;
    //        for (int i = nums[p]; i >=1; i--) {
    //            boolean cur = dfs(nums, i + p);
    //            if (cur) {
    //                return true;
    //            }
    //        }
    //        return false;
    //    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 0};
        canJump(nums);
    }

}
