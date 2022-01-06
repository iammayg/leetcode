package ac;

import java.util.Scanner;


public class AC898 {
    static int N = 500 + 10;
    static int e[][] = new int[N][N];
    static int f[][] = new int[N][N];
    static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                e[i][j] = in.nextInt();
            }
        }
        f[1][1]=e[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int r = Integer.MIN_VALUE;
                int l = Integer.MIN_VALUE;
                if (check(i - 1, j - 1)) {
                    l = f[i - 1][j - 1];
                }
                if (check(i - 1, j)) {
                    r = f[i - 1][j];
                }
                f[i][j] = Math.max(l, r) + e[i][j];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, f[n][i]);
        }
        System.out.println(max);
//        System.out.println();
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print(f[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    static boolean check(int i, int j) {//2 1
        return i > 0 && j > 0 && j <= i;
    }
}
