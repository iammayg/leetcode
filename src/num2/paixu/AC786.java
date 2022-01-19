package num2.paixu;

/**
 * topk
 * 找到第k大的数
 * <p>
 * 改造快排
 * 堆
 */
public class AC786 {
    public static int quick_select(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return arr[r];//
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
            } while (arr[rr] > x);
            if (ll < rr) {
                swap(arr, ll, rr);
            }
        }
        //sl记录左边有多少个数。
        // 如果k<=sl那么第k小的数在rr左边，否则在rr右边
        int sl = rr - l + 1;
        if (k <= sl) {
            return quick_select(arr, l, rr, k);
        } else {
            return quick_select(arr, rr + 1, r, k - sl);
        }

    }

    public static void swap(int[] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {50, 43, 63, 97, 30, 89, 89, 94, 30, 33};
        //        int[] arr = new int[] {2, 3, 1};
        for (int i = 1; i <= arr.length; i++) {
            System.out.print(quick_select(arr, 0, arr.length - 1, i) + " ");
        }
    }
}
