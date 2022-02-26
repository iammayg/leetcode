package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-26
 */
public class Leetcode338 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            int j = i;
            int c = 0;
            while (j > 0) {
                j = j - (j & -j);
                c++;
            }
            res[i] = c;
        }
        return res;
    }
}
