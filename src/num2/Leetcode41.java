package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-03-12
 */
public class Leetcode41 {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] - 1 != i && nums[i] < n && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,1};
        System.out.println(firstMissingPositive(nums));
    }
}
