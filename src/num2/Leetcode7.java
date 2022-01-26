package num2;

/**
 */
public class Leetcode7 {

    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (x > 0 && res > (Integer.MAX_VALUE - x / 10) / 10) {
                return 0;
            }
            if (x < 0 && res < (Integer.MIN_VALUE - x / 10) / 10) {
                return 0;
            }
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(0));
    }
}
