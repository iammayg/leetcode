package num2;

/**
 */
public class Leetcode14 {
    public static String longestCommonPrefix(String[] strs) {
        int max = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < max && j < strs[i].length(); j++) {
                if (strs[i].charAt(j) != strs[i - 1].charAt(j)) {
                    max = j;
                }
            }
            max = Math.min(j, max);
        }
        return strs[0].substring(0, max);
    }

    public static void main(String[] args) {
        String[] strings = new String[] {
                "ab", "a"
        };
        System.out.println(longestCommonPrefix(strings));
    }
}
