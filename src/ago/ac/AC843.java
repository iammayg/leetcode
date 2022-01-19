package ago.ac;

import java.util.Scanner;


public class AC843 {
    static int N = 20;
    static int n;

    static boolean[] row = new boolean[N];//当前行是否放过
    static boolean[] col = new boolean[N];//当前列是否放过
    static boolean[] dg = new boolean[N];//对角线是否放过
    static boolean[] udg = new boolean[N];//斜对角线是否放过

    static char[][] g = new char[N][N];

    static void dfs(int x, int y, int s) {//s：当前还有多少个皇后
        if (y == n) {
            y = 0;
            x++;
        }
        if (x == n) {
            if (s == 0) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(g[i][j]);
                    }
                    System.out.println();
                }
                System.out.println();

            }
            return;
        }

        //当前点不妨皇后
        dfs(x, y + 1, s);

        //当前点放皇后
        if (!row[x] && !col[y] && !dg[x + y] && !udg[x - y + n]) {//todo 对角线和斜对角线如何表示
            row[x] = col[y] = dg[x + y] = udg[x - y + n] = true;
            g[x][y] = 'Q';
            dfs(x, y + 1, s - 1);
            row[x] = col[y] = dg[x + y] = udg[x - y + n] = false;
            g[x][y] = '.';
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = '.';
            }
        }
        dfs(0, 0, n);
    }
}
