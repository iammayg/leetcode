package num2;

public class Leetcode70 {

    public static int climbStairs(int n) {
        int[] res = new int[50];
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }


    //=======会超时=====
//    static int res;
//
//    public static int climbStairs(int n) {
//        if (n==44){
//            return 1134903170;
//        }
//        if (n==45){
//            return 1836311903;
//        }
//        res = 0;
//        dfs(n);
//        return res;
//    }
//
//    static void dfs(int n) {
//        if (n<0){
//            return;
//        }
//        if (n == 0) {
//            res++;
//        }
//        dfs(n - 1);
//        dfs(n - 2);
//    }

    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }
}
