package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-26
 */
public class Leetcode287 {
    public static int findDuplicate(int[] nums) {
        int a = nums[nums[0]];
        int b = nums[0];
        while (a != b) {
            a = nums[nums[a]];
            b = nums[b];
        }
        //        System.out.println(a);
        b = 0;
        while (a != b) {
            a = nums[a];
            b = nums[b];
        }
        return a;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(arr));
    }
}