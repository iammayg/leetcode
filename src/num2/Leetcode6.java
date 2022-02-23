package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-23
 */
public class Leetcode6 {
    public static String convert(String s, int n) {
        if (n == 1) {
            return s;
        }
        String res = "";
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                for (int j = i; j < s.length(); j += 2 * n - 2) {
                    res += s.charAt(j);
                }
            } else {
                int j = i;
                int k = 2 * n - i - 2;
                while (j < s.length()) {
                    res += s.charAt(j);
                    if (k < s.length()) {
                        res += s.charAt(k);
                    }
                    j += 2 * n - 2;
                    k += 2 * n - 2;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }
    //true  PINALSIGYAHRPI
    //false PAHNAPLSIIGYYIIRR
}
