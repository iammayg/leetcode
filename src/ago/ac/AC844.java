package ago.ac;


import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 给定一个 n×m 的二维整数数组，用来表示一个迷宫，数组中只包含 0 或 1，其中 0 表示可以走的路，1 表示不可通过的墙壁。
 * <p>
 * 最初，有一个人位于左上角 (1,1) 处，已知该人每次可以向上、下、左、右任意一个方向移动一个位置。
 * <p>
 * 请问，该人从左上角移动至右下角 (n,m) 处，至少需要移动多少次。
 * <p>
 * 数据保证 (1,1) 处和 (n,m) 处的数字为 0，且一定至少存在一条通路。
 * <p>
 * 输入格式
 * 第一行包含两个整数 n 和 m。
 * <p>
 * 接下来 n 行，每行包含 m 个整数（0 或 1），表示完整的二维数组迷宫。
 * <p>
 * 输出格式
 * 输出一个整数，表示从左上角移动至右下角的最少移动次数。
 * <p>
 * 数据范围
 * 1≤n,m≤100
 * 输入样例：
 * 5 5
 * 0 1 0 0 0
 * 0 1 0 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 * 输出样例：
 * 8
 */

/**
 * while(queue is not empty){
 * 队头拿出
 * 扩展队头
 * }
 */
public class AC844 {
    static int n;
    static int m;
    static int[][] arr;
    static int[][] d;//距离

    static Queue<SimpleEntry<Integer, Integer>> queue = new LinkedList<>();

    static int bfs() {
        queue.add(new SimpleEntry<>(0, 0));

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            SimpleEntry<Integer, Integer> pre = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = pre.getKey() + dx[i];
                int y = pre.getValue() + dy[i];

                if (x >= 0 && x < n && y >= 0 && y < m && arr[x][y] == 0 && d[x][y] == -1) {
                    d[x][y] = d[pre.getKey()][pre.getValue()] + 1;
                    queue.add(new SimpleEntry<>(x, y));
                }
            }
        }
        return d[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[n][m];
        //        n = m = 10;
        //        arr = new int[][] {{0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
        //                {0, 0, 1, 0, 0, 1, 0, 0, 0, 1},
        //                {0, 0, 1, 0, 0, 1, 0, 0, 0, 0},
        //                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        //                {1, 1, 1, 0, 0, 0, 0, 1, 0, 0},
        //                {0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
        //                {0, 0, 0, 1, 1, 1, 0, 1, 1, 1},
        //                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        //                {0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
        //                {0, 0, 0, 0, 1, 0, 1, 1, 1, 0}};

        d = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = in.nextInt();
                d[i][j] = -1;
            }
        }
        d[0][0] = 0;

        System.out.println(bfs());
    }
}
