package num2;

public class Leetcode11 {
    /**
     * 属于贪心类型了
     * 思路:双指针
     * 指针l和r分别指向柱子的左右两端 然后柱子短的指针向中间移动，如果大于最大值则更新最大值。这个过程结束后两个指针一定能经过最优解
     * <p>
     * 证明
     * 记最优解的两个横坐标分别是i和j。移动过程中肯定有一个指针先指向i或j，假设l先指向i，只需要在l指向i的时候r一定能指向j
     * 使用反证法：假设有j右边有柱子k高度大于x对应的柱子高度，这时候才会移动x，但是这时候i，j则不是最优解
     */
    public static int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            max = Math.max(max, (r - l) * Math.min(height[l], height[r]));
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4, 3, 2, 1, 4};
        System.out.println(maxArea(arr));
    }
}
