package num2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-22
 */
public class Leetcode56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> resList = new ArrayList<>();
        resList.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] lastArr = resList.get(resList.size() - 1);
            if (intervals[i][0] <= lastArr[1]) {
                lastArr[1] = Math.max(intervals[i][1], lastArr[1]);
            } else {
                resList.add(new int[] {intervals[i][0], intervals[i][1]});
            }
        }
        int[][] res = new int[resList.size()][];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = new int[] {resList.get(i)[0], resList.get(i)[1]};
        }
        return res;
    }
}
