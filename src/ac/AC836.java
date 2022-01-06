package ac;

import java.util.Scanner;

public class AC836 {
    static int n;
    static int m;
    static int[] p;

    //返回x元素的集合，并将路径上所有点指向根结点
    /**
     * 理解
     * 如果p[x]不是根结点 将p[x]指向根结点
     * 否则 返回x的根结点(p[x])
     * 递归的时候 记住该函数是干嘛的，递归逻辑中直接用该函数，然后写一下边界逻辑(如果是根结点直接返回 该节点的p[x])
     */
    static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];//不能写 return x;因为这里不是if elas的关系，在递归的时候上一行代码已经对p[x] 的值做了改变，这时候p[x]已经指向x的根节点
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        in.nextLine();

        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            String[] op = in.nextLine().split(" ");
            int a = Integer.parseInt(op[1]);
            int b = Integer.parseInt(op[2]);
            if (op[0].equals("M")) {
                p[find(a)] = find(b);
            } else {
                System.out.println(find(a) == find(b) ? "Yes" : "No");
            }
        }
    }
}
