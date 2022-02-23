package num2;

public class Leetcode75 {
    /**
     * 这个题背过思路就好了，比较特殊
     * <p>
     * - 从左向右 维护三个指针j,i,k，让他们保持0到j-1==0，j到i-1==1，k+1到结尾==2。初始状态i=j=0，k=nums.length-1（初始状态是满足这个性质的）
     * - 然后一直维护这个性质移动i指针，当i>k的时候就结束（可以看下循环之后执行的语句，每次循环要么i+1要么k+1，所以肯定能走到i>k，等i>k循环结束，数组就排好序了），具体维护过程看代码
     */
    public void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        int k = nums.length - 1;

        while (i <= k) {
            if (nums[i] == 0) {
                swap(nums, i, j);
                i++;
                j++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, k, i);
                k--;
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
