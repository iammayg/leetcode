package num2;

/**
 *
 */
public class LeetCode88 {
    //    输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    //    输出：[1,2,2,3,5,6]

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = nums1.length - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 >= 0 && p2 >= 0) {
                if (nums1[p1] >= nums2[p2]) {
                    nums1[p] = nums1[p1];
                    p1--;
                } else {
                    nums1[p] = nums2[p2];
                    p2--;
                }
            } else if (p1 >= 0) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[] {1, 2, 3, 0, 0, 0,};
        int[] num2 = new int[] {2, 5, 6};
        merge(num1, 3, num2, 3);
        for (int i = 0; i < num1.length; i++) {
            System.out.println(num1[i]);
        }
    }
}
