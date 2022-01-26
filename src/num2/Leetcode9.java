package num2;

/**
 */
public class Leetcode9 {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int y=x;
        long res = 0;
        while (x > 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return res==y;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
