package num2;

import java.util.Scanner;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-10
 */
public class AC789 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        while (q-- > 0) {
            int k = in.nextInt();
            int resl = getL(nums, k);
            int resr = getR(nums, k);
            System.out.println(resl + " " + resr);
        }
    }

    static int getL(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l] == k ? l : -1;
    }

    static int getR(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= k) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return nums[l] == k ? l : -1;
    }
}
