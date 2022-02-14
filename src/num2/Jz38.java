package num2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-12
 * dfs
 * 字符串的排列
 */
public class Jz38 {

    static char[] path;
    static int n;
    static char[] chars;
    static Set<String> res;
    static boolean[] st;


    public static String[] permutation(String s) {
        chars = s.toCharArray();
        Arrays.sort(chars);
        n = chars.length;
        path = new char[n];
        st = new boolean[n];
        res = new HashSet<>();

        dfs(0);

        String[] strres = new String[res.size()];
        res.toArray(strres);
        return strres;


    }

    /**
     * 修改递归函数，使得该递归函数只会生成不重复的序列。
     * 具体地，我们只要在递归函数中设定一个规则，保证在填每一个空位的时候重复字符只会被填入一次。具体地，我们首先对原字符串排序，保证相同的字符都相邻，在递归函数中，我们限制每次填入的字符一定是这个字符所在重复字符集合中「从左往右第一个未被填入的字符」
     * <p>
     * 本质上，相当于给重复字符定义了一个序。
     * 如{ a, b, b, b, c }，每次只用剩余字符集合中找到的第一个b。
     * 相当于定义为{ a, b1, b2, b3, c }，保证最后得到的序列中 b 按序排列就可以避免重复。
     * 如{ b, c, b, b, a } 只要{ b1, c, b2, b3, a }这一种，而不要 { b2, c,b3, b1, a }等，就不会重复。
     */

    static void dfs(int p) {
        if (p == n) {
            String curres = "";
            for (int i = 0; i < p; i++) {
                curres += path[i];
            }
            res.add(curres);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (st[i] || (i > 0 && chars[i] == chars[i - 1] && st[i])) {
                continue;
            }
            st[i] = true;
            path[p] = chars[i];
            dfs(p + 1);
            st[i] = false;
        }
    }

    public static void main(String[] args) {
        permutation("abb");
    }
}
