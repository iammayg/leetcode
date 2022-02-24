package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-23
 */
public class Leetcode62 {

    public int uniquePaths(int mm, int nn) {
        int[][] res = new int[mm][nn];
        for (int i = 0; i < mm; i++) {
            res[i][0] = 1;
        }
        for (int i = 0; i < nn; i++) {
            res[0][i] = 1;
        }
        for (int i = 1; i < mm; i++) {
            for (int j = 1; j < nn; j++) {
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[mm-1][nn-1];
    }
    //    static int res;
    //    static int m;
    //    static int n;
    //
    //    public int uniquePaths(int mm, int nn) {
    //        res = 0;
    //        m = mm;
    //        n = nn;
    //        dfs(0,0);
    //        return res;
    //    }
    //
    //    static void dfs(int x, int y) {
    //        if (x >= m || y >= n) {
    //            return;
    //        }
    //        if (x == m - 1 && y == n - 1) {
    //            res++;
    //            return;
    //        }
    //        dfs(x + 1, y);
    //        dfs(x, y + 1);
    //    }
}
