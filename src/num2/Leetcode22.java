package num2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-01-26
 */
public class Leetcode22 {

    public static List<String> generateParenthesis(int n) {
        int[] arr = new int[] {n, n};// arr[0]意思是 ( 的数量

        List<String> res = new ArrayList<>();
        dfs("", arr, res, n);
        return res;

    }

    static void dfs(String path, int[] arr, List<String> res, int n) {
        if (arr[0] == 0 && arr[1] == 0) {
            res.add(path);
        }
        if (arr[0] > 0) {
            arr[0]--;
            dfs(path + "(", arr, res, n);
            arr[0]++;
        }
        if (arr[1] > 0) {
            int countL = n - arr[0];
            int countR = n - arr[1];
            if (countL > countR) {
                arr[1]--;
                dfs(path + ")", arr, res, n);
                arr[1]++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
    }
}
