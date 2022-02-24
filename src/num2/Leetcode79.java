package num2;

public class Leetcode79 {
    static char[][] board;
    static String word;
    static boolean[][] st;
    static int xl;
    static int yl;

    public static boolean exist(char[][] bb, String ww) {
        board = bb;
        word = ww;
        xl = bb.length;
        yl = bb[0].length;
        st = new boolean[xl][yl];
        for (int i = 0; i < xl; i++) {
            for (int j = 0; j < yl; j++) {
                if (board[i][j] == ww.charAt(0)) {
                    boolean res = dfs(i, j, 0);
                    if (res) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    static boolean dfs(int x, int y, int p) {
        if (p == board.length-1) {
            return true;
        }

        if (x < 0 || y < 0 || x >= xl || y > yl) {
            return false;
        }
        if (!st[x][y] && word.charAt(p) == board[x][y]) {
            st[x][y] = true;
            if (!st[x + 1][y]) {
                if (dfs(x + 1, y, p + 1)) {
                    return true;
                }
            }
            if (!st[x - 1][y]) {
                if (dfs(x - 1, y, p + 1)) {
                    return true;
                }
            }
            if (!st[x][y + 1]) {
                if (dfs(x, y + 1, p + 1)) {
                    return true;
                }
            }
            if (!st[x][y - 1]) {
                if (dfs(x, y - 1, p + 1)) {
                    return true;
                }
            }
            st[x][y] = false;
        }
        return false;
    }

}
