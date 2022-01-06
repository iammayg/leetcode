package ac;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class AC845 {
    static Queue<String> queue = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Map<String, Integer> map = new HashMap<>();


    static int bfs(String start) {
        queue.add(start);
        while (!queue.isEmpty()) {
            String cur = queue.poll();

            if (cur.equals("12345678x")) {
                return map.get("12345678x");
            }

            int p = cur.indexOf('x');
            int x = p / 3;
            int y = p % 3;
            for (int i = 0; i < 4; i++) {
                int a = dx[i] + x;
                int b = dy[i] + y;
                int targetp = a * 3 + b % 3;
                if (a >= 0 && b >= 0 && a < 3 && b < 3) {
                    String newState = changeChar(p, targetp, cur);
                    if (!map.containsKey(newState)) {
                        map.put(newState, map.get(cur) + 1);
                        queue.add(newState);
                    }
                }


            }
        }
        Integer res = map.get("12345678x");
        return Objects.isNull(res) ? -1 : res;
    }

    static String changeChar(int p1, int p2, String s) {
        int start = Math.min(p1, p2);
        int end = Math.max(p1, p2);
        char startChar = s.charAt(start);
        char endChar = s.charAt(end);
        String res = s.substring(0, start) + endChar + s.substring(start + 1, end) + startChar + s
                .substring(end + 1, s.length());
        return res;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String start = "";
        for (int i = 0; i < 9; i++) {
            start += scanner.next();

        }
        map.put(start, 0);
        int res = bfs(start);
        System.out.println(res);

    }


}
