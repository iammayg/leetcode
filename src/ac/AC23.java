package ac;


public class AC23 {
    static int nx;
    static int ny;

    public static boolean hasPath(char[][] matrix, String str) {
        if (matrix.length == 0) {
            return false;
        }
        nx = matrix.length;
        ny = matrix[0].length;

        for (int i = 0; i < nx; i++) {
            for (int j = 0; j < ny; j++) {
                boolean[][] path = new boolean[nx][ny];
                if (dfs(i, j, matrix, path, 0, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    //nx ny 矩阵长宽，p当前字符串位置,path当前位置是否用过
    public static boolean dfs(int x, int y, char[][] matrix, boolean[][] path, int p, String str) {



        if (x == nx || x < 0 || y == ny || y < 0) {
            return false;
        }

        if (matrix[x][y] != str.charAt(p) || path[x][y]) {
            return false;
        }

        if (p == str.length() - 1) {
            return true;
        }

        boolean hasPath=false;

        path[x][y] = true;

        /**
         * dfs 当前的上下左右，如果上向左右不合法 则恢复现场。如果合法则不恢复
         */
        hasPath= dfs(x, y + 1, matrix, path, p + 1, str) || dfs(x, y - 1, matrix, path, p + 1, str) || dfs(x + 1, y,
                matrix, path, p + 1, str) || dfs(x - 1, y, matrix, path, p + 1, str);

        if (!hasPath){
            path[x][y]=false;
        }
        return hasPath;

    }

    public static void main(String[] args) {
        char[][] matrix = new char[1][2];
        matrix[0]=new char[]{'a','a'};
//        matrix[0] = new char[] {'A', 'B', 'C', 'E'};
//        matrix[1] = new char[] {'S', 'F', 'E', 'S'};
//        matrix[2] = new char[] {'A', 'D', 'E', 'E'};
        System.out.println(hasPath(matrix, "aaa"));
    }
}
