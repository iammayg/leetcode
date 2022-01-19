package ago.ac;


public class AC24 {
    static int count = 0;

    public static int movingCount(int threshold, int rows, int cols) {
        dfs(0, 0, threshold, rows, cols, new boolean[rows][cols]);
        return count;
    }

    public static void dfs(int x, int y, int k, int nx, int ny, boolean[][] path) {//path[][]--记录是否走过这个位置
        if (x < 0 || y < 0 || x == nx || y == ny || path[x][y]) {
            return;
        }
        path[x][y] = true;
        int curBsum = bsum(x) + bsum(y);
        if (curBsum <= k) {
            count ++;
            dfs(x-1,y,k,nx,ny,path);
            dfs(x+1,y,k,nx,ny,path);
            dfs(x,y-1,k,nx,ny,path);
            dfs(x,y+1,k,nx,ny,path);
        }

    }

    public static int bsum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(movingCount(1, 2, 2));
    }
}
