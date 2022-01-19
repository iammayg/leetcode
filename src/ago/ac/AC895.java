package ago.ac;

import java.util.Scanner;

public class AC895 {
    static int N = 1010;
    static int[] e = new int[N];
    static int n;
    static int[] f = new int[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            e[i] = in.nextInt();
        }
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            int maxl = 0;
            for (int j = 1; j < i; j++) {
                if (e[j] < e[i]) {
                    maxl = Math.max(maxl, f[j]);
                }
            }
            f[i]=maxl+1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, f[i]);
        }
        System.out.println(max);
    }
}
