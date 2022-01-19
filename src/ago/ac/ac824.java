package ago.ac;


import java.util.Scanner;

/**
 * 给定一个整数 n，将数字 1∼n 排成一排，将会有很多种排列方法。
 * <p>
 * 现在，请你按照字典序将所有的排列方法输出。
 * <p>
 * 输入格式
 * 共一行，包含一个整数 n。
 * <p>
 * 输出格式
 * 按字典序输出所有排列方案，每个方案占一行。
 * <p>
 * 数据范围
 * 1≤n≤7
 * 输入样例：
 * 3
 * 输出样例：
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 1 2
 * 3 2 1
 */
public class ac824 {
    static int n;
    static int N = 10;
    static int[] path = new int[N];
    static boolean[] st = new boolean[N];//该 数字 是否被占用

    public static void dfs(int p) {
        if (p == n) {
            print(path);
        }
        for (int i = 1; i <= n; i++) {
            if (!st[i]) {
                path[p] = i;
                st[i] = true;
                dfs(p + 1);
                st[i] = false;
            }
        }
    }

    public static void print(int[] path) {
        for (int i = 0; i < path.length; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dfs(0);


    }

}
