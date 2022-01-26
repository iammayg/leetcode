package num2;

/**
 * topk问题
 * 大根堆：将k个元素入堆，后续元素依次与堆顶元素比较，如果大于等于堆顶元素则不管，如果小于堆顶元素则将堆顶元素删除，将当前元素入堆（堆顶元素保留了前k个元素中的最大值
 * 快排变形
 * <p>
 * //这个题使用小根堆也是可以的但是相比于大根堆不是最优解。小根堆的思路是将所有元素入堆，然后弹出k次堆顶元素
 */
public class Offer40 {


    /**
     * 快排变形
     */
    public static void quickSort(int[] arr, int l, int r, int k) {//k表示 需要找出当前界限中前k个数
        if (l >= r) {
            return;
        }
        int x = arr[l];
        int ll = l - 1;
        int rr = r + 1;
        while (ll < rr) {
            do {
                ll++;
            } while (arr[ll] < x);
            do {
                rr--;
            }
            while (arr[rr] > x);
            if (ll < rr) {
                swap(arr, ll, rr);
            }
        }


        //        if (kp <= r) {
        //            if (rr > kp) {
        //                quickSort(arr, k, l, rr);
        //            } else {
        //                quickSort(arr, k, l, rr);
        //                quickSort(arr, k, rr + 1, kp);
        //            }
        //        } else {
        //            quickSort(arr, k, l, rr);
        //            quickSort(arr, k, rr + 1, r);
        //        }


        int sl = rr - l + 1;
        if (rr == k) {
            return;
        } else if (rr < k) {
            quickSort(arr, rr + 1, r, k - sl);
        } else {
            quickSort(arr, l, rr, k);
        }


    }

    public static void swap(int[] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }


    public static int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, k, 0, arr.length - 1);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5, 3, 1, 2, 0, 4};
        int[] res = getLeastNumbers(arr, 6);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


    //---------------------------------------------------------------------------------------------------------

    /**
     * 小根堆
     */
    //        static int size;
    //        static int[] heap = new int[100010];
    //        public static int[] getLeastNumbers(int[] arr, int k) {
    //            size = arr.length;
    //
    //            for (int i = 0; i < size; i++) {
    //                heap[i + 1] = arr[i];
    //            }
    //
    //            for (int i = size / 2; i > 0; i--) {
    //                down(i);
    //            }
    //            int[] res = new int[k];
    //            for (int i = 1; i <= k; i++) {
    //                res[i - 1] = heap[1];
    //                deleteMin();
    //            }
    //            return res;
    //        }
    //
    //        public static void deleteMin() {
    //            heap[1] = heap[size];
    //            size--;
    //            down(1);
    //        }
    //
    //        public static void down(int k) {
    //            while (2 * k <= size) {
    //                int nk;
    //                if (2 * k + 1 <= size) {
    //                    nk = heap[2 * k] < heap[2 * k + 1] ? 2 * k : 2 * k + 1;
    //                } else {
    //                    nk = 2 * k;
    //                }
    //                if (heap[nk] >= heap[k]) {
    //                    break;
    //                }
    //                swap(heap, k, nk);
    //                k = nk;
    //            }
    //        }
    //
    //        public static void swap(int[] arr, int p1, int p2) {
    //            int temp = arr[p1];
    //            arr[p1] = arr[p2];
    //            arr[p2] = temp;
    //        }

    //---------------------------------------------------------------------------------------------------------

    /**
     * 大根堆
     */
    //    public static int[] getLeastNumbers(int[] arr, int k) {
    //        if (k == 0) {
    //            return new int[0];
    //        }
    //        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
    //            @Override
    //            public int compare(Integer o1, Integer o2) {
    //                return o2 - o1;
    //            }
    //        });
    //        int i;
    //        for (i = 0; i < k; i++) {
    //            heap.add(arr[i]);
    //        }
    //        for (; i < arr.length; i++) {
    //            if (heap.peek() > arr[i]) {
    //                heap.poll();
    //                heap.add(arr[i]);
    //            }
    //        }
    //        int[] res = new int[k];
    //        for (int j = 0; j < k; j++) {
    //            res[j] = heap.remove();
    //        }
    //        return res;
    //    }

}
