package num2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-14
 * 双指针、滑动窗口
 */
public class Leetcode3 {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int j = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (!set.contains(curChar)) {
                set.add(curChar);
            } else {
                while (j < i) {
                    set.remove(s.charAt(j));
                    if (s.charAt(j) == curChar) {
                        j++;
                        break;
                    }
                    j++;
                }
                set.add(curChar);
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
