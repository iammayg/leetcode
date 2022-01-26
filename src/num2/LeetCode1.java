package num2;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class LeetCode1 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x) && map.get(x) != i) {
                return new int[] {i, map.get(x)};
            }
        }
        return null;

    }


    public static void main(String[] args) {
        System.out.println(19400+19400+19400+6400+21000+63405+21000+21000+10335+21000+21000+21000+12229+21000+21000+21000+1747);
        int[] arr = new int[] {3,3};
        int[] ints = twoSum(arr, 6);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
