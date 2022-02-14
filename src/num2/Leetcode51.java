package num2;

import java.util.ArrayList;
import java.util.List;

/**
 * n皇后问题
 * dfs
 */
public class Leetcode51 {

    /**
     * 如果需要通过遍历来判断行列对角线斜对角线是否可以放置皇后写起来代码比较长，可以简化下代码
     * 代码长主要是由于需要判断行&列&两条对角线上是否已经放过皇后，可以记录下对角线是否已经放过来简化代码
     * 这里有个技巧
     * row[x] x行是否放过
     * col[y] y列 是否放过
     * dg[y-x+n] x,y 所在的对角线是否放过
     * udg[x+y] x,y所在的斜对角线是否放过
     * <p>
     * q1：为什么udg[x+y]可以表示斜对角线？为什么dg[y-x]可以表示斜对角线？
     * 如果将方格放入坐标轴中，斜对角线可以表示为y=-x+b，即对角线上的元素对应的坐标截距是相等的，即对角线上的所有元素都可以映射到同一个数，那么可以用这个数来表示这条对角线。（不同对角线的截距一定不相同）
     * 所以b=y+x，对于一条对角线上的任何坐标都可以对应到相同的b。
     * 斜对角线也是一样，在坐标轴表示为y=x+b，也可以使用b=y-x来表示
     * <p>
     * q2：为什么表示斜对角线的时候不是y-x而是y-x+n
     * y-x有可能是负数，对应到表示她的坐标的时候，坐标不能是负数，所以可以给他们加上一个相同的数
     */

    static boolean[][] path;
    static List<List<String>> res;
    static int n;
    static boolean[] row, col, dg, udg;

    public static List<List<String>> solveNQueens(int count) {
        n = count;
        row = new boolean[n];
        col = new boolean[n];
        dg = new boolean[2 * n];
        udg = new boolean[2 * n];
        path = new boolean[n][n];
        res = new ArrayList<>();

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
                List<String> curres = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    String row = "";
                    for (int j = 0; j < n; j++) {
                        String point = path[i][j] ? "Q" : ".";
                        row += point;
                    }
                    curres.add(row);
                }
                res.add(curres);
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

    public static void main(String[] args) {
        solveNQueens(4);
    }


    //============================================================================================================================================================================================

    //    static boolean[][] path;
    //    static List<List<String>> res;
    //    static int n;
    //
    //    public static List<List<String>> solveNQueens(int count) {
    //
    //        n = count;
    //        path = new boolean[n][n];
    //        res = new ArrayList<>();
    //
    //
    //        dfs(n, 0);
    //        return res;
    //    }
    //
    //    static void dfs(int sy, int p) {
    //        if (p > n * n) {
    //            return;
    //        }
    //
    //        if (p == n * n) {
    //            if (sy == 0) {
    //                List<String> curres = new ArrayList<>();
    //                for (int i = 0; i < n; i++) {
    //                    String row = "";
    //                    for (int j = 0; j < n; j++) {
    //                        String point = path[i][j] ? "Q" : ".";
    //                        row += point;
    //                    }
    //                    curres.add(row);
    //                }
    //                res.add(curres);
    //            }
    //            return;
    //        }
    //
    //        int x = p / n;
    //        int y = p % n;
    //        boolean flag = true;
    //        for (int i = 0; i < n; i++) {
    //            if (path[x][i]) {
    //                flag = false;
    //                break;
    //            }
    //        }
    //        for (int i = 0; i < n; i++) {
    //            if (path[i][y]) {
    //                flag = false;
    //                break;
    //            }
    //        }
    //
    //        int xx = x;
    //        int yy = y;
    //        while (xx >= 0 && yy >= 0) {
    //            if (path[xx][yy]) {
    //                flag = false;
    //                break;
    //            }
    //            xx--;
    //            yy--;
    //        }
    //        xx = x;
    //        yy = y;
    //        while (xx < n && yy >= 0) {
    //            if (path[xx][yy]) {
    //                flag = false;
    //                break;
    //            }
    //            xx++;
    //            yy--;
    //        }
    //        xx = x;
    //        yy = y;
    //        while (xx >= 0 && yy < n) {
    //            if (path[xx][yy]) {
    //                flag = false;
    //                break;
    //            }
    //            xx--;
    //            yy++;
    //        }
    //
    //        xx = x;
    //        yy = y;
    //        while (xx < n && yy < n) {
    //            if (path[xx][yy]) {
    //                flag = false;
    //                break;
    //            }
    //            xx++;
    //            yy++;
    //        }
    //
    //        if (flag) {
    //            path[x][y] = true;
    //            dfs(sy - 1, p + 1);
    //            path[x][y] = false;
    //        }
    //        dfs(sy, p + 1);
    //
    //    }
}
