package ac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AC51 {
    static int n;
    static boolean[] flag;
    static List<List<Integer>> res = new ArrayList<List<Integer>>();
    static Integer[] path;

    public static List<List<Integer>> permutation(int[] nums) {
        n = nums.length;

        path = new Integer[n];
        for (int i = 0; i < nums.length; i++) {
            flag = new boolean[n];
            dfs(i, nums, 0);
        }
        return res;
    }

    static void dfs(int p, int[] nums, int c) {//p nums当前位置，c：已经计算的个数
        if (p == nums.length || flag[p]) {
            return;
        }
        flag[p] = true;
        path[c] = nums[p];
        if (c == n - 1) {
            res.add(new ArrayList<Integer>(Arrays.asList(path)));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {
                dfs(i, nums, c + 1);
                flag[i] = false;

            }
        }

    }

    public static void main(String[] args) {
        permutation(new int[] {1, 1, 3});
        System.out.println(res);
    }

}
