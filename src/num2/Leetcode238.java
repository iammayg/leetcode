package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-26
 */
public class Leetcode238 {
    public int[] productExceptSelf(int[] nums) {
        int[] p = new int[nums.length];//p[i]表示i前边所有数的乘积
        p[0] = 1;
        for (int i = 1; i < p.length; i++) {
            p[i] = nums[i] * p[i - 1];
        }
        int s = 1;//s用来存后边所有数的乘积
        for (int i = nums.length - 1; i >= 0; i--) {
            p[i] = p[i] * s;
            s = s * nums[i];
        }
        return p;
    }
}
