package num2;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class Leetcode17 {
    //    static String[][] str = new String[10][];
    //
    //    static {
    //        str[2] = new String[] {"a", "b", "c"};
    //        str[3] = new String[] {"d", "e", "f"};
    //        str[4] = new String[] {"g", "h", "i"};
    //        str[5] = new String[] {"j", "k", "l"};
    //        str[6] = new String[] {"m", "n", "o"};
    //        str[7] = new String[] {"p", "q", "r", "s"};
    //        str[8] = new String[] {"t", "u", "v"};
    //        str[9] = new String[] {"w", "x", "y", "z"};
    //    }
    //
    //
    //    public static List<String> letterCombinations(String digits) {
    //        if (digits.length() == 0) {
    //            return new ArrayList<>();
    //        }
    //        List<String> res = Arrays.asList("");
    //
    //        int p = 0;
    //        while (p < digits.length()) {
    //            int num = Character.getNumericValue(digits.charAt(p));
    //            List<String> curStrs = res;
    //            res = new ArrayList<>();
    //            for (String curStr : curStrs) {
    //                for (String ss : str[num]) {
    //                    res.add(curStr + ss);
    //                }
    //            }
    //            p++;
    //        }
    //        return res;
    //    }

    //使用搜索
    // ============================================================================================================================================
    /**
     * 其实是一个深搜问题，画个图看下就明白了
     */

    static String[][] str = new String[10][];

    static {
        str[2] = new String[] {"a", "b", "c"};
        str[3] = new String[] {"d", "e", "f"};
        str[4] = new String[] {"g", "h", "i"};
        str[5] = new String[] {"j", "k", "l"};
        str[6] = new String[] {"m", "n", "o"};
        str[7] = new String[] {"p", "q", "r", "s"};
        str[8] = new String[] {"t", "u", "v"};
        str[9] = new String[] {"w", "x", "y", "z"};
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        dfs(digits, 0, "", res);
        return res;
    }

    static void dfs(String digits, int p, String path, List<String> res) {
        if (p == digits.length()) {
            res.add(path);
            return;
        }
        int num = Character.getNumericValue(digits.charAt(p));
        for (String s : str[num]) {
            dfs(digits, p + 1, path + s, res);
        }

    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
