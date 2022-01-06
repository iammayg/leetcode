package ac;

/**
 * 若一个由图中所有点构成的序列 A 满足：对于图中的每条边 (x,y)，x 在 A 中都出现在 y 之前，则称 A 是该图的一个拓扑序列。
 * 有向无环图一定是一个拓扑图
 * 有环图一定不是拓扑图
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 由上边的结论 判断是否有拓扑排序只要判断是否是有向无环图就可以了
 * <p>
 * 1、入队所有入度为0的点
 * 2、while(queue is not empty){
 * 2.1 t =queue.poll();
 * 2.2 枚举t的所有出边t->j并删除(即把j的入度-1)
 * 2.3if(d[j]==0) 把j入队
 * }
 * //如果 有环 则环上的点一定不会入队
 */
public class AC848 {
    static int N = 100010;
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] h = new int[N];
    static int[] d = new int[N];
    static int[] q = new int[N];
    static int inx = 0;
    static int n;
    static int m;

    static void add(int a, int b) {
        e[inx] = b;
        ne[inx] = h[a];
        h[a] = inx;
        inx++;
        d[b]++;
    }

    static boolean topsort() {
        int p1 = 0;
        int p2 = -1;
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                q[++p2] = i;
            }
        }
        while (p1 <= p2) {
            int t = q[p1++];
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                d[j] = d[j] - 1;
                if (d[j] == 0) {
                    q[++p2] = j;
                }
            }
        }
        return n - 1 == p2;
    }

    public static void main(String[] args) {
        Arrays.fill(h,-1);

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 0; i < m; i++) {
            add(in.nextInt(), in.nextInt());
        }
        if (topsort()) {
            for (int i = 0; i < n; i++) {
                System.out.print(q[i] + " ");
            }
        } else {
            System.out.println(-1);
        }
    }
}
