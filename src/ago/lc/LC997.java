package ago.lc;

import java.util.Arrays;


public class LC997 {
    static int NN = 2010;

    static int[] h;
    static int[] e;
    static int[] ne;
    static int inx;
    static int[] r;
    static int[] c;

    static void add(int a, int b) {
        e[inx] = b;
        ne[inx] = h[a];
        h[a] = inx;
        inx++;

        //
        c[a] = c[a] + 1;
        r[b] = r[b] + 1;
    }

    public static int findJudge(int N, int[][] trust) {
        h = new int[NN];
        e = new int[NN];
        ne = new int[NN];
        inx = 0;
        r = new int[NN];
        c = new int[NN];
        Arrays.fill(h, -1);
        for (int i = 0; i < trust.length; i++) {
            add(trust[i][0], trust[i][1]);
        }
        for (int i = 1; i <= N; i++) {
            if (r[i] == N - 1 && c[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] ints = new int[5][2];
        ints[0] = new int[] {1, 3};
        ints[1] = new int[] {1, 4};
        ints[2] = new int[] {2, 3};
        ints[3] = new int[] {2, 4};
        ints[4] = new int[] {4, 3};
        System.out.println(findJudge(4, ints));
    }

}
