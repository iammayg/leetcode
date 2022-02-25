package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-25
 */
public class Leetcode136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int x : nums) {
            res ^= x;
        }
        return res;
    }
}
