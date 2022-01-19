package ago.lc;

import java.util.Arrays;


public class LC207  {
    static int N = 100010;
    static int[] e;
    static int[] ne;
    static int[] h;
    static int inx;
    static int[] d;

    static void add(int a, int b) {
        e[inx] = b;
        ne[inx] = h[a];
        h[a] = inx;
        inx++;
        d[b]++;
    }

    /**
     * 入队所有入度为0的点
     * while(queue is not empty){
     * t=queue.poll();
     * 删掉t所有出边t->j，d[j]--;
     * if(d[j]==0) 入队j;
     * }
     * reture 所有点都入队
     */
    static boolean topSort(int numCourses) {
        int p1 = 0;
        int p2 = -1;
        int[] q = new int[N];
        for (int i = 0; i < numCourses; i++) {
            if (d[i] == 0) {
                q[++p2] = i;
            }
        }
        while (p1 <= p2) {
            int cur = q[p1++];
            for (int i = h[cur]; i != -1; i = ne[i]) {
                int j = e[i];
                d[j]--;
                if (d[j] == 0) {
                    q[++p2] = j;
                }
            }
        }
        return numCourses == p2 + 1;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        e = new int[N];
        ne = new int[N];
        h = new int[N];
        d = new int[N];
        inx = 0;
        Arrays.fill(h, -1);
        for (int i = 0; i < prerequisites.length; i++) {
            add(prerequisites[i][0], prerequisites[i][1]);
        }
        return topSort(numCourses);
    }

    public static void main(String[] args) {
        int[][] arr = new int[2][0];
        arr[0] = new int[] {1, 0};
        arr[1] = new int[] {0, 1};
        System.out.println(canFinish(2, arr));
    }
}
