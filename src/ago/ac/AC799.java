package ago.ac;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class AC799 {
    static int N = 10010;
    static int[] e = new int[N];
    static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            e[i] = in.nextInt();
        }
        int j = 0;
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!set.contains(e[i])) {
                set.add(e[i]);
            } else {
                j++;
            }
            max = Math.max(max, i - j + 1);
        }
        System.out.println(max);
    }
}
