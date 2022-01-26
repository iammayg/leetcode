package num2;

/**
 */
public class Leetcode8 {
    public static int myAtoi(String s) {
        boolean start = true;

        int res = 0;

        int p = 0;
        boolean zs = true;
        while (p < s.length()) {
            char c = s.charAt(p);
            if (start) {
                if ((c == '+' || c == '-') || (c >= '0' && c <= '9')) {
                    start = false;
                    if (c == '-') {
                        zs = false;
                    } else if (c >= '0' && c <= '9') {
                        int num = Character.getNumericValue(c);
                        res = num;
                    }
                } else if (c == ' ') {
                    p++;
                    continue;
                } else {
                    return 0;
                }
            } else {
                if (c >= '0' && c <= '9') {
                    int num = Character.getNumericValue(c);
                    if (zs && res > (Integer.MAX_VALUE - num) / 10) {
                        return Integer.MAX_VALUE;
                    } else if (!zs && res > (Integer.MIN_VALUE + num) / -10) {
                        return Integer.MIN_VALUE;
                    }
                    res = res * 10 + num;
                } else {
                    return zs ? res : -1 * res;
                }
            }

            p++;
        }
        return zs ? res : -1 * res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-91283472332"));
    }
}
