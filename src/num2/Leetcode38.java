package num2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-10
 */
public class Leetcode38 {
    static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(1, "1");
    }

    public String countAndSay(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int i = 1;
        while (++i <= n) {
            if (!map.containsKey(i)) {
                String preString = map.get(i - 1);
                StringBuilder res = new StringBuilder();

                int start = 0;
                while (start < preString.length()) {
                    int end = start;
                    while (end < preString.length() && preString.charAt(start) == preString.charAt(end)) {
                        end++;
                    }
                    res.append(end - start).append(preString.charAt(start));
                    start = end;
                }

                map.put(i, res.toString());
            }
        }
        return map.get(n);
    }
}
