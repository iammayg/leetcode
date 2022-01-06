package ac;

import java.util.Arrays;
import java.util.Scanner;

public class AC846 {
    static int n;
    static int N = 100010;
    static int M = 2 * N;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static boolean[] st = new boolean[N];//该点是否被搜过
    static int inx = 0;

    static int ans = Integer.MAX_VALUE;


    //https://www.acwing.com/video/21/ 1:22:00

    static void add(int a, int b) {//插入a指向b的边
        e[inx] = b;
        ne[inx] = h[a];
        h[a] = inx;
        inx++;
    }

    //返回以u为根结点的子树的节点数量（包括u）
    static int dfs(int u) {
        st[u] = true;

        int sum = 1;//以u为根结点的子树的节点数量（包括u）
        int res = 0;//存储删除u后每个联通块的最大值
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!st[j]) {
                int ssum = dfs(j);//以j为节点的子节点
                res = Math.max(res, ssum);
                sum += ssum;

            }
        }
        res = Math.max(res, n - sum);
        ans = Math.min(ans, res);
        st[u] = false;
        return sum;
    }



    public static void main(String[] args) {
        Arrays.fill(h, -1);

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n - 1; i++) {
            String[] nums = in.nextLine().split(" ");
            add(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
            add(Integer.parseInt(nums[1]), Integer.parseInt(nums[0]));
        }
        dfs(0);
        System.out.println(ans);
    }
}

/**
 * 图的存储和搜索基本代码
 * <p>
 * static int n;
 * static int N = 100010;
 * static int M = 2 * N;
 * static int[] h = new int[N];
 * static int[] e = new int[M];
 * static int[] ne = new int[M];
 * static boolean[] st = new boolean[N];//该点是否被搜过
 * static int inx = 0;
 * <p>
 * <p>
 * static void add(int a, int b) {//插入a指向b的边
 * e[inx] = b;
 * ne[inx] = h[a];
 * h[a] = inx;
 * inx++;
 * }
 * <p>
 * static void dfs(int u) {
 * st[u] = true;
 * <p>
 * for (int i = h[u]; i != -1; i = ne[i]) {
 * int j = e[i];
 * System.out.println(j);
 * if (!st[j]) {
 * dfs(j);
 * }
 * }
 * st[u]=false;
 * }
 */