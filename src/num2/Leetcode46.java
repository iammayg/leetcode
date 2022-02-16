package num2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-15
 */
public class Leetcode46 {
    static int[] path;
    static List<List<Integer>> res;
    static int[] arr;
    static boolean[] st;

    public static List<List<Integer>> permute(int[] nums) {
        path = new int[nums.length];
        res = new ArrayList<>();
        arr = nums;
        st = new boolean[nums.length];
        dfs(0);
        return res;
    }

    static void dfs(int u) {
        if (u == arr.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < path.length; i++) {
                list.add(path[i]);
            }
            res.add(list);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!st[i]) {
                st[i] = true;
                path[u] = arr[i];
                dfs(u + 1);
                st[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        permute(new int[]{1,2});
    }
}
