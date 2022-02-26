package num2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-25
 */
public class Leetcode139 {
    static Set<String> set;
    static String str;

    public static boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        str = s;
        return dfs(0);
    }

    static boolean dfs(int p) {
        if (p >= str.length()) {
            return true;
        }
        for (int i = p; i < str.length(); i++) {
            if (set.contains(str.substring(p, i + 1))) {
                boolean curRes = dfs(i + 1);
                if (curRes) {
                    return true;
                }

            }
        }
        return false;
    }

    //"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
    //["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
    public static void main(String[] args) {
        String s =
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> arr = new ArrayList<>();
        arr.addAll(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaaa",
                "aaaaaaaaaaa"));
        System.out.println(wordBreak(s, arr));
    }
}
