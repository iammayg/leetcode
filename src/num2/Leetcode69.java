package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-23
 */
public class Leetcode69 {
    public static int mySqrt(int x) {
        double l = 1;
        double r = x;
        while (l < r) {
            if (r - l < 1e-6) {
                return l * l > x ? (int) l : (int) r;
            }
            double mid = (l + r) / 2;
            double y = mid * mid;
            if (y == x) {
                return (int) mid;
            } else if (y > x) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        mySqrt(4);
    }
}
