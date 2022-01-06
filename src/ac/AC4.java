package ac;

import java.util.Scanner;

public class AC4 {
    static int N = 110;
    static int v[] = new int[N];
    static int w[] = new int[N];
    static int s[] = new int[N];
    static int f[][] = new int[N][N];
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
            s[i] = in.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j < v[i]) {
                    f[i][j] = f[i - 1][j];
                } else {
                    int count = 0;
                    int max = 0;
                    while (count * v[i] <= j && count <= s[i]) {
                        max = Math.max(max, f[i - 1][j - v[i] * count] + count * w[i]);
                        count++;
                    }
                    f[i][j]=max;
                }
            }
        }
        System.out.println(f[n][m]);
    }
}
