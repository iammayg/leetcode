package num2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-25
 */
public class Leetcode128 {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        int max = 1;
        for (int x : nums) {
            if (!set.contains(x - 1)) {
                int y = x;
                while (set.contains(y)) {
                    y++;
                }
                max = Math.max(max, y - x);
            }
        }
        return max;

    }
}
