package num2;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class Leetcode13 {
    static Map<String, Integer> map = new HashMap<>();

    // int[] nums = new int[] {
    //                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    //        };
    //        String[] strs = new String[] {
    //                "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    //        };
    static {
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
    }

    public static int romanToInt(String s) {
        int i = 0;
        int res = 0;
        while (i < s.length()) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                res += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                res += map.get(String.valueOf(s.charAt(i)));
                i++;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
