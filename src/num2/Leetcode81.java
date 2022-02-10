package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-10
 */
public class Leetcode81 {
    /**
     * 这个题和33题有所不同
     * 33题不能有重复元素，所以数组开始元素和结束元素一定不相同，则可以通过和和数组第一个元素的大小比较将数组分为左右两部分
     * 此题中等于nums[0]的元素即可能在左边也可能在右边，所以不能直接使用二分，采取做法是将数组后边和nums[0]相等的元素删除
     * <p>
     * 这样最坏情况下时间复杂度是O(n)，和扫描一遍数组时间复杂度是相等的
     */
    public static boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (r >= 0 && nums[r] == nums[0]) {
            r--;
        }
        int end = r;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] >= nums[0]) {
                l = mid;
            } else {
                r = mid - 1;
            }

        }
        if (target >= nums[0]) {
            l = 0;
        } else {
            r = end;
            l = l + 1 == nums.length ? l : l + 1;
        }
        while (l < r) {
            int mid = r + l + 1 >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return nums[l] == target;

    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 2, 2, 3, 2, 2, 2};
        System.out.println(search(nums, 3));
    }
}
