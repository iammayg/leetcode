package num2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-01-26
 */
public class Leetcode20 {

    static Map<Character, Character> map = new HashMap<>();

    static {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character cc = stack.pop();
                if (map.get(cc)!=c){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("(([]){})"));
    }
}
