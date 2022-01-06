package ac;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AC847 {
    static int n;
    static int m;
    static int N = 100010;
    static int M = 2 * N;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static int inx = 0;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] d = new int[N];// 1到各点的距离


    static void add(int a, int b) {
        e[inx] = b;
        ne[inx] = h[a];
        h[a] = inx;
        inx++;
    }

    static int bfs() {
        while (!queue.isEmpty()) {
            int t = queue.poll();

            for (int i = h[t]; i != -1; i = ne[i]) {
                int cur = e[i];
                if (d[cur] == -1) {//注意 判断下 该点没有遍历过
                    queue.add(cur);
                    d[cur] = d[t] + 1;
                }
            }
        }
        return d[n];
    }

    public static void main(String[] args) {
        Arrays.fill(h, -1);
        Arrays.fill(d, -1);

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
        }
        queue.add(1);
        d[1] = 0;//1到1的距离为0
        System.out.println(bfs());

    }


}
