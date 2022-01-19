package ago.ac;

import java.util.Scanner;

public class AC626 {
    static int N = 100010;
    static int m;
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int head = -1;
    static int idx = 0;

    static void insertH(int x) {
        e[idx] = x;
        ne[idx] = head;
        head = idx;
        idx++;
    }

    static void del(int k) {
        if (k == 0) {//删除头节点kk
            head = ne[head];
        } else {
            //要删除点下标 k-1
            ne[k-1]=ne[ne[k-1]];
        }
    }

    static void insert(int k, int x) {
        e[idx] = x;
        ne[idx] = ne[k - 1];
        ne[k - 1] = idx;
        idx++;
    }

    static void print() {
        int p = head;
        while (p>-1){
            System.out.print(e[p] + " ");
            p = ne[p];
        }
    }

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        in.nextLine();

            for (int i = 0; i < m; i++) {
                String[] op = in.nextLine().split("\\ ");
                switch (op[0]) {
                    case "H":
                        insertH(Integer.parseInt(op[1]));
                        break;
                    case "D":
                        del(Integer.parseInt(op[1]));
                        break;
                    case "I":
                        insert(Integer.parseInt(op[1]), Integer.parseInt(op[2]));
                        break;
                }
            }
            print();
        }
}
