package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-12
 * dfs
 */
public class Leetcode52 {
    static boolean[][] path;
    static int n;
    static boolean[] row, col, dg, udg;
    static int res;

    public static int totalNQueens(int count) {
        n = count;
        row = new boolean[n];
        col = new boolean[n];
        dg = new boolean[2 * n];
        udg = new boolean[2 * n];
        path = new boolean[n][n];
        res = 0;

        dfs(0, 0, count);
        return res;
    }

    static void dfs(int x, int y, int sy) {
        if (y == n) {//这里有个技巧，省去判断，每次向后移动列就可以了
            y = 0;
            x++;
        }
        if (x == n) {
            if (sy == 0) {
                res++;
            }
            return;
        }
        //不放皇后
        dfs(x, y + 1, sy);//只需要移动列，如上说明
        //放皇后
        if (!row[x] && !col[y] && !dg[y - x + n] && !udg[x + y]) {
            row[x] = col[y] = udg[x + y] = dg[y - x + n] = true;
            path[x][y] = true;
            dfs(x, y + 1, sy - 1);
            path[x][y] = false;
            row[x] = col[y] = udg[x + y] = dg[y - x + n] = false;
        }
    }
}
