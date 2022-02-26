package num2;

import java.util.Arrays;
import java.util.Scanner;

public class AC826 {
    static int N = 100010;
    static int[] e;
    static int[] ne;
    static int idx;
    static int head;

    static void init() {
        e = new int[N];
        ne = new int[N];
        Arrays.fill(ne, -1);
        idx = 0;
        head = -1;
    }

    static void insert(int x) {
        e[idx] = x;
        ne[idx] = head;
        head = idx;
        idx++;
    }


    static void insertTo(int k, int x) {
        e[idx] = x;
        ne[idx] = ne[k - 1];
        ne[k - 1] = idx;
        idx++;
    }


    static void delete(int k) {
        if (k == 0) {//删除头节点kk
            head = ne[head];
        } else {
            //要删除点下标 k-1
            ne[k - 1] = ne[ne[k - 1]];
        }
    }


    static void printList() {
        int p = head;
        while (p > -1) {
            System.out.print(e[p] + " ");
            p = ne[p];
        }
    }

    static void print() {
        int p = head;
        while (p > -1) {
            System.out.print(e[p] + " ");
            p = ne[p];
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        in.nextLine();
        init();

        for (int i = 0; i < m; i++) {
            String ss = in.nextLine();
            if (ss.startsWith("H")) {
                // System.out.print(ss);
                int x = Integer.parseInt(ss.split(" ")[1]);
                insert(x);
            } else if (ss.startsWith("I")) {
                int k = Integer.parseInt(ss.split(" ")[1]);
                int x = Integer.parseInt(ss.split(" ")[2]);
                insertTo(k, x);
            } else if (ss.startsWith("D")) {
                int k = Integer.parseInt(ss.split(" ")[1]);
                delete(k);
            }
        }
        print();

    }
}
