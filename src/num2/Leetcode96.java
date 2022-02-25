package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-24
 */
public class Leetcode96 {
    public int numTrees(int n) {
        return dfs(1, n);
    }

    static int dfs(int l, int r) {
        if (l >= r) {
            return 1;
        }
        int res = 0;
        for (int i = l; i <= r; i++) {
            res += dfs(l, i - 1) * dfs(i + 1, r);
        }
        return res;
    }
}
