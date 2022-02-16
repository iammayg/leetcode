package num2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-15
 */
public class Leetcode54 {

    /**
     * 二维数组的坐标变换技巧
     */
    public static List<Integer> spiralOrder(int[][] m) {
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};
        List<Integer> res = new ArrayList<>();
        boolean[][] st = new boolean[m.length][m[0].length];

        int d = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < m.length * m[0].length; i++) {
            st[x][y] = true;
            res.add(m[x][y]);

            int a = x + dx[d];
            int b = y + dy[d];

            if (a < 0 || a >= m.length || b < 0 || b >= m[0].length || st[a][b]) {
                d = (d + 1) % 4;
                a = x + dx[d];
                b = y + dy[d];
            }
            x = a;
            y = b;
        }
        return res;
    }

    //======================================================================================================================================================

    //    public static List<Integer> spiralOrder(int[][] m) {
    //        List<Integer> res = new ArrayList<>();
    //        int minx = 0;
    //        int maxx = m.length - 1;
    //        int miny = 0;
    //        int maxy = m[0].length - 1;
    //        int x = 0;
    //        int y = 0;
    //        int status = 1;
    //
    //        res.add(m[x][y]);
    //        while (res.size() < m.length * m[0].length) {
    //            if (status == 1) {
    //                y++;
    //                while (y <= maxy) {
    //                    res.add(m[x][y]);
    //                    y++;
    //                }
    //                y--;
    //                minx++;
    //                status = 2;
    //            } else if (status == 2) {
    //                x++;
    //                while (x <= maxx) {
    //                    res.add(m[x][y]);
    //                    x++;
    //                }
    //                x--;
    //                maxy--;
    //                status = 3;
    //            } else if (status == 3) {
    //                y--;
    //                while (y >= miny) {
    //                    res.add(m[x][y]);
    //                    y--;
    //                }
    //                y++;
    //                maxx--;
    //                status = 4;
    //            } else if (status == 4) {
    //                x--;
    //                while (x >= minx) {
    //                    res.add(m[x][y]);
    //                    x--;
    //                }
    //                x++;
    //                miny++;
    //                status = 1;
    //            }
    //        }
    //        return res;
    //    }

    public static void main(String[] args) {
        int[][] m = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        spiralOrder(m);
    }
}
