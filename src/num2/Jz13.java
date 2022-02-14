package num2;

/**
 * dfs
 */
public class Jz13 {
    static boolean[][] st;
    static int res;
    static int k;
    static int m;
    static int n;

    public int movingCount(int mm, int nn, int kk) {
        k = kk;
        m = mm;
        n = nn;
        st = new boolean[m][n];
        res = 0;
        dfs(0, 0);

        return res;
    }

    static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return;
        }

        if (st[x][y]) {
            return;
        }
        if (bitSum(x) + bitSum(y) <= k) {
            res++;
            st[x][y] = true;
            dfs(x + 1, y);
            dfs(x, y + 1);
            dfs(x - 1, y);
            dfs(x, y - 1);
        }
    }

    static int bitSum(int x) {
        int r = 0;
        while (x > 0) {
            r += x % 10;
            x /= 10;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(bitSum(24));
    }
}
