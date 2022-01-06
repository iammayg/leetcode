package ac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class AC908 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<AC905.Range> ranges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            AC905.Range range = new AC905.Range(l, r);
            ranges.add(range);
        }

        Collections.sort(ranges);
        int res = 0;
        int i = 0;
        while (i < ranges.size()) {
            int curR = ranges.get(i).getR();
            while (i<ranges.size()&&ranges.get(i).getL()<=curR){
                i++;
            }
            res++;
        }
        System.out.println(res);

    }

    static class Range implements Comparable<AC905.Range> {
        int l;

        public int getL() {
            return l;
        }

        int r;

        public int getR() {
            return r;
        }

        public Range(int l, int r) {
            this.l = l;
            this.r = r;
        }


        @Override
        public int compareTo(AC905.Range o) {
            return r - o.r;
        }
    }
}
