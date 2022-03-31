package num2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-01-27
 */
public class Leetcode29 {
    public static int divide(int x, int y) {
        boolean isR = false;
        if (x < 0 && y > 0 || x > 0 && y < 0) {
            isR = true;
        }
        List<Long> list = new ArrayList<>();
        long a = Math.abs((long) x);
        long b = Math.abs((long) y);

        for (long i = b; i <= a; i += i) {
            list.add(i);
        }
        long res = 0L;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (a >= list.get(i)) {
                a -= list.get(i);
                res += 1L << i;
            }
        }
        if (isR) {
            return (int) (-1 * res);
        }
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) res;


    }

    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
        System.out.println(divide(-2147483648, 1));
    }
}
