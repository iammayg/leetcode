package num2;

import java.util.Arrays;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-10
 */
public class Leetcode36 {
    public static boolean isValidSudoku(char[][] board) {
        boolean[] bb = new boolean[9];

        //判断行
        for (int i = 0; i < 9; i++) {
            Arrays.fill(bb, false);
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int p = Character.getNumericValue(c) - 1;
                    if (bb[p]) {
                        return false;
                    }
                    bb[p] = true;
                }
            }
        }

        //判断列
        for (int i = 0; i < 9; i++) {
            Arrays.fill(bb, false);
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (c != '.') {
                    int p = Character.getNumericValue(c) - 1;
                    if (bb[p]) {
                        return false;
                    }
                    bb[p] = true;
                }
            }
        }

        //判断九宫格
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                Arrays.fill(bb, false);
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        char c = board[i + k][j + l];
                        if (c != '.') {
                            int p = Character.getNumericValue(c) - 1;
                            if (bb[p]) {
                                return false;
                            }
                            bb[p] = true;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] cc = new char[][] {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(cc));
    }
}
