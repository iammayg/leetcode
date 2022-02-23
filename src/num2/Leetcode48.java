package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-23
 */
public class Leetcode48 {
    public void rotate(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                swap(arr, i, j, j, i);
            }
        }
        int length = arr[0].length % 2 == 0 ? arr[0].length / 2 : arr[0].length / 2 + 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < length; j++) {
                swap(arr, i, j, i, arr[i].length - 1 - j);
            }
        }
    }

    static void swap(int[][] arr, int x1, int y1, int x2, int y2) {
        int temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

}
