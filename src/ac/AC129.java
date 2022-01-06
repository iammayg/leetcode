package ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class AC129 {
    static int n;
    static Stack<Integer> state2 = new Stack<Integer>();
    static int state3=1;
    static List<Integer> state1 = new ArrayList<Integer>();
    static int count = 20;

    static void dfs() {
        if (count <= 0) {
            return;
        }
        if (state1.size() == n) {
            count--;
            for (int i = 0; i < state1.size(); i++) {
                System.out.print(state1.get(i) + "");
            }
            System.out.println();
        }
        if (!state2.isEmpty()) {
            int cur = state2.pop();
            state1.add(cur);
            dfs();
            state2.push(cur);
            state1.remove(state1.size() - 1);
        }
        if (state3 <= n) {
            int cur = state3;
            state2.push(cur);
            state3++;
            dfs();
            state3--;
            state2.pop();
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs();
    }
}
