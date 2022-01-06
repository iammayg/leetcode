package ac;

import java.util.Scanner;

public class AC897 {
    static int N = 1010;
    static char[] s1 = new char[N];
    static char[] s2 = new char[N];
    static int[][] f = new int[N][N];
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        for (int i = 1; i <= n; i++) {
            s1[i] = s.charAt(i - 1);
        }
        s = in.nextLine();
        for (int i = 1; i <= m; i++) {
            s2[i] = s.charAt(i - 1);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int max = Math.max(f[i - 1][j], f[i][j-1]);
                max = Math.max(max, s1[i] == s2[j] ? f[i-1][j-1]+1:max);
                f[i][j] = max;
            }
        }
        System.out.println(f[n][m]);

    }
}
