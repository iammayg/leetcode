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
                boolean res = dfs(i, j, 0);
                if (res) {
                    return true;
                }
            }
        }
        return false;

    }

    static boolean dfs(int x, int y, int p) {//lc79：代码写起来有一点点麻烦。dfs()函数里传入的是将要比较的值，然后通过p指针的位置来判断是否比较完成。
        if (p == word.length()) {
            return true;
        }

        if (x < 0 || y < 0 || x >= xl || y >= yl) {
            return false;
        }
        if (word.charAt(p) != board[x][y] || st[x][y]) {
            return false;
        }
        st[x][y] = true;
        if (dfs(x + 1, y, p + 1)) {
            return true;
        }
        if (dfs(x - 1, y, p + 1)) {
            return true;
        }
        if (dfs(x, y + 1, p + 1)) {
            return true;
        }
        if (dfs(x, y - 1, p + 1)) {
            return true;
        }
        st[x][y] = false;
        return false;
    }

}
