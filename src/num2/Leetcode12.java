package num2;

/**
 */
public class Leetcode12 {
    // 模拟题｜｜找规律题
    //
    public static String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        while (num >= 1000) {
            res.append("M");
            num -= 1000;
        }
        if (num >= 900) {
            res.append("CM");
            num -= 900;
        }
        if (num >= 500) {
            res.append("D");
            num -= 500;
        }
        if (num >= 400) {
            res.append("CD");
            num -= 400;
        }
        while (num >= 100) {
            res.append("C");
            num -= 100;
        }
        if (num >= 90) {
            res.append("XC");
            num -= 90;
        }
        if (num >= 50) {
            res.append("L");
            num -= 50;
        }
        if (num >= 40) {
            res.append("XL");
            num -= 40;
        }
        while (num >= 10) {
            res.append("X");
            num -= 10;
        }
        if (num >= 9) {
            res.append("IX");
            num -= 9;
        }
        if (num >= 5) {
            res.append("V");
            num -= 5;
        }
        if (num >= 4) {
            res.append("IV");
            num -= 4;
        }
        while (num >= 1) {
            num--;
            res.append("I");
        }
        return res.toString();

    }
    //----------------------------------------------------------------------------------------------------------------
    //简化代码

    public static String intToRoman2(int num) {
        String res = "";
        int[] nums = new int[] {
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };
        String[] strs = new String[] {
                "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };
        for (int i = 0; i < nums.length; i++) {
            while (num > nums[i]) {
                res += strs[i];
                num -= nums[i];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(intToRoman2(58));
    }
}
