package ac;

import java.util.Scanner;

public class AC3 {
    static int N = 1010;
    static int[] v = new int[N];
    static int[] w = new int[N];
    static int[][] f = new int[N][N];
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }

        for (int i = 1; i <= n; i++) {//物品
            for (int j = 1; j <= m; j++) {//体积

                if (j < v[i]) {//当前物品 无法选
                    f[i][j] = f[i - 1][j];
                } else {//当前物品可以选
                    //不选 or 选
                    int max = f[i][j];
                    int count = 0;//当前物品选的件数
                    while (j >= count * v[i]) {
                        int containIMax = f[i - 1][j - count * v[i]] + count * w[i];
                        max = Math.max(max, containIMax);//选or不选
                        count++;
                    }
                    f[i][j] = max;
                }
            }
        }
        System.out.print(f[n][m]);
    }
}
