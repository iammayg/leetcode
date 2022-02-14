package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-14
 */
public class Leetcode5 {
    public static String longestPalindrome(String s) {
        int max = 1;
        String res = String.valueOf(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int l = i - 1;
            int r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                r++;
                l--;
            }
            int start = l + 1;
            int len = r - l - 1;
            if (len > max) {
                res = s.substring(start, start + len);
            }
            max = Math.max(max, len);


            l = i - 1;
            r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                r++;
                l--;
            }
            start = l + 1;
            len = r - l - 1;
            if (len > max) {
                res = s.substring(start, start + len);
            }
            max = Math.max(max, len);
        }
        return res;
    }

    public static void main(String[] args) {
        longestPalindrome("cbbd");
    }
}
