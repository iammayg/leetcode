package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-25
 */
public class Leetcode191 {
    public static int hammingWeight(int n) {

        int res = 0;
        while (n != 0) {
            res++;
            n = n - lowbit(n);
        }
        return res;

    }

    static int lowbit(int x) {
        return x & -x;
    }

    public static void main(String[] args) {
    }
}
