package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-05
 */
public class Leetcode31 {
    public static void nextPermutation(int[] nums) {
        int k = nums.length - 1;
        while (k - 1 >= 0 && nums[k] <= nums[k - 1]) {
            k--;
        }
        if (k == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int j = nums.length - 1;
        while (j > k - 1 && nums[j] <= nums[k - 1]) {
            j--;
        }
        swap(nums, k - 1, j);
        reverse(nums, k, nums.length - 1);
    }

    static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            swap(arr, l, r);
            l++;
            r--;
        }
    }

    static void swap(int[] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 5, 1};
        nextPermutation(nums);
    }
}
