package num2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-03-02
 */
public class Leetcode347 {
    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        /*
        常规做法1.统计各个元素出现次数2.根据出现次数进行排序o(nlogn)
        优化做法：1.统计各个元素出现次数
        2.放入count数组,y=count[i]表示出现i次的有y个元素
        3.从后向前扫描数组count，找出出现k次的元素出现的个数
        4.扫描数组，找出出现次数大于第三步得到的个数
        */
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }

        }
        int[] count = new int[nums.length + 1];
        for (int key : map.keySet()) {
            count[map.get(key)]++;
        }
        int i = count.length - 1;
        int l=k;
        while (i > 0 && l > 0) {
            l -= count[i];
            i--;
        }
        // System.out.print(i);
        int[] res = new int[k];
        int p = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > i) {
                res[p++] = key;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        topKFrequent(new int[] {-1,-1}, 1);
    }
}
