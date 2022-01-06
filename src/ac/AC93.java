package ac;

import java.util.Scanner;


public class AC93 {
    private static int n;
    private static int m;
    private static int N = 50;
    private static boolean[] flag = new boolean[N];//是否占用

    private static void dfs(int p, int c) {//c还剩多少可选
        if (p > n + 1 || c < 0) {
            return;
        }
        if (c == 0) {
            for (int i = 1; i <= n; i++) {
                if (flag[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            return;
        }

        flag[p] = true;
        dfs(p + 1, c - 1);
        flag[p] = false;
        dfs(p + 1, c);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        dfs(1, m);

    }
}
