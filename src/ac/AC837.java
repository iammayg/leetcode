package ac;

import java.util.Scanner;

public class AC837 {
    static int n;
    static int m;
    static int[] p;
    static int[] c;//只保证根结点 有意义

    //返回x所在的集合，并将x 到根结点路径上所有的点指向 根结点
    static int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        in.nextLine();

        p = new int[n + 1];
        c = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
            c[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            String[] op = in.nextLine().split(" ");
            int a = Integer.parseInt(op[1]);
            if (op[0].equals("C")) {
                int b = Integer.parseInt(op[2]);
                if (find(a)==find(b)){//特判 一下，如果已经  在同一个集合  则不更新数量
                    continue;
                }
                c[find(a)] += c[find(b)];//注意这里需要先更新数量。因为如果先更新父节点再更新数量则更新完父节点后两个节点的根结点相同，其实是把同一个集合的数量加了两次
                p[find(b)] = find(a);
            } else if (op[0].equals("Q1")) {
                int b = Integer.parseInt(op[2]);
                System.out.println(find(a) == find(b) ? "Yes" : "No");
            } else {
                System.out.println(c[find(a)]);
            }
        }
    }
}
