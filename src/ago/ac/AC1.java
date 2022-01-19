package ago.ac;

import java.util.Scanner;


public class AC1 {
    static int N = 1010;
    static int w[] = new int[N];
    static int v[] = new int[N];
    static int f[][] = new int[N][N];//f[i][j]：前i个物品背包容量为j时候的 所有选法 的最大值。
    static int n;
    static int vPack;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        vPack = in.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= vPack; j++) {
                if (j < v[i]) {
                    f[i][j] = f[i - 1][j];
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - v[i]] + w[i]);
                }
            }
        }
        System.out.print(f[n][vPack]);
    }
}
