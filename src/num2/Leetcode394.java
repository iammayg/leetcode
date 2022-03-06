package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-03-04
 */
public class Leetcode394 {
    static int p;//p定义成全局变量，因为下次递归后p需要维持更新后的值


    public static String decodeString(String s) {
        p = 0;
        return dfs(s);
    }

    static String dfs(String s) {
        String res = "";
        while (p < s.length() && s.charAt(p) != ']') {//如果是左括号当前递归结束
            if (s.charAt(p) == '[') {
                p++;
            } else if (Character.isDigit(s.charAt(p))) {
                int x = 0;
                int l = 0;
                while (p + l < s.length() && Character.isDigit(s.charAt(p + l))) {
                    x = x * 10 + Character.getNumericValue(s.charAt(p + l));
                    l++;
                }
                p = p + l;
                String y = dfs(s);
                p++;//递归完之后忽略掉右括号
                while (x > 0) {
                    res += y;
                    x--;
                }
            } else if (Character.isUpperCase(s.charAt(p)) || Character.isLowerCase(s.charAt(p))) {
                res += s.charAt(p);
                p++;
            }
        }
        return res;
    }

    //    "3[z]2[2[y]pq4[2[jk]e1[f]]]ef"
    public static void main(String[] args) {
        System.out.println(decodeString("100[leetcode]"));
    }

    //    输入：s = "3[a]2[bc]"
    //    输出："aaabcbc"
}
