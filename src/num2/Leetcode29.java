package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-01-27
 */
public class Leetcode29 {
    public static int divide(int a, int b) {
        boolean fs = false;
        if (a * b < 0) {
            fs = true;
        }
        a = Math.abs(a);
        b = Math.abs(b);
        int res = 0;
        while (a >= b) {
            a = a - b;
            res++;
        }
        return fs ? res * -1 : res;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }
}
