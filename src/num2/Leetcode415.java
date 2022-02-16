package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-15
 */
public class Leetcode415 {
    public static String addStrings(String num1, String num2) {
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int ys = 0;
        String res = "";
        while (p1 >= 0 || p2 >= 0 || ys > 0) {
            int cur1 = 0;
            int cur2 = 0;
            if (p1 >= 0) {
                cur1 = Character.getNumericValue(num1.charAt(p1));
            }
            if (p2 >= 0) {
                cur2 = Character.getNumericValue(num2.charAt(p2));
            }
            int cursum = cur1 + cur2 + ys;
            res = cursum % 10 + res;
            ys = cursum / 10;
            p1--;
            p2--;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = addStrings("1", "9");
    }
}
