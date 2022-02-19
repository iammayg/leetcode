package num2;

import java.util.Stack;


/**
 * 思路：放如的时候只能向s1放
 * 取的时候只能从s2取
 */

public class Leetcode232 {
    static Stack<Integer> s1;
    static Stack<Integer> s2;

    public Leetcode232() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        s1.push(x);
    }

    public int pop() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    public int peek() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
