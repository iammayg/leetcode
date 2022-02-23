package num2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-23
 */
public class Leetcode49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedString = String.valueOf(chars);
            if (map.containsKey(sortedString)) {
                res.get(map.get(sortedString)).add(strs[i]);
            } else {
                map.put(sortedString, res.size());
                ArrayList<String> cur = new ArrayList<>();
                cur.add(strs[i]);
                res.add(cur);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strings = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strings);
    }
}
