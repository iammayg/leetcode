package ago.ac;

import java.util.Scanner;


public class AC9 {
    static int n;
    static int m;
    static int N = 110;
    static int[][] w = new int[N][N];//w[i][j] 第i组的第j个物品的价值
    static int[][] v = new int[N][N];
    static int[] count = new int[N];
    static int[][] f = new int[N][N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        for (int i = 1; i <= n; i++) {
            count[i] = in.nextInt();
            for (int j = 1; j <= count[i]; j++) {
                v[i][j] = in.nextInt();
                w[i][j] = in.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j < minV(i)) {
                    f[i][j] = f[i - 1][j];
                } else {
                    //第i个物品可以选的情况
                    //又包括 选or不选
                    int max = 0;
                    for (int k = 1; k <= count[i]; k++) {//选改组第几个
                        if (v[i][k] <= j) {
                            max = Math.max(max, f[i - 1][j - v[i][k]] + w[i][k]);//选当前物品 or 不选当前物品
                            max = Math.max(max, f[i-1][j]);
                        }
                    }
                    f[i][j] = max;
                }
            }
        }
        System.out.println(f[n][m]);
    }

    static int minV(int i) {//i组物品 最小体积
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= count[i]; j++) {
            min = Math.min(min, v[i][j]);
        }
        return min;
    }
}
