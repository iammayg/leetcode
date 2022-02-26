package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-26
 */
public class Leetcode240 {
    /**
     * 从矩阵右上角开始找，如果t==target返回；如果t>target，去掉一列；如果t<target，去掉一行
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0;
        int y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0) {
            int t = matrix[x][y];
            if (t == target) {
                return true;
            } else if (t > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
