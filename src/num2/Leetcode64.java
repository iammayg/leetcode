package num2;

public class Leetcode64 {
    public int minPathSum(int[][] arr) {
        int[][] res = new int[arr.length][arr[0].length];
        res[0][0] = arr[0][0];
        for (int i = 1; i < arr.length; i++) {
            res[i][0] = res[i - 1][0] + arr[i][0];
        }
        for (int i = 1; i < arr[0].length; i++) {
            res[0][i]=res[0][i-1]+arr[0][i];
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                res[i][j]=Math.min(res[i-1][j],res[i][j-1])+arr[i][j];
            }
        }
        return res[arr.length-1][arr[0].length-1];
    }
}
