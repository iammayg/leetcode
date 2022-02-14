package num2;

import java.util.Scanner;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-10
 * dfs 数字的排列
 */
public class AC842 {
    static boolean[] st;
    static int[] path;
    static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        path = new int[n];
        st = new boolean[n + 1];
        dfs(0);
    }

    static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
        }
        //这里其实是有一个思路的，这个循环多考虑下
        //到当前位置 不是选择和不选择的问题，而是通过循环来将所有可以选择的位置都通过不同方案选一遍，因为题目要求所有数字都需要选择一遍

        for (int i = 1; i <= n; i++) {
            if (!st[i]) {
                path[u] = i;
                st[i] = true;
                dfs(u + 1);
                st[i] = false;
            }
        }

    }
}
