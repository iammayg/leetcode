package num2.paixu;


public class Main {

    public static void quick_sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int x = arr[l];
        int ll = l - 1;
        int rr = r + 1;
        while (ll < rr) {
            do {
                ll++;
            }
            while (arr[ll] < x);//比较关键的一点，等于分界点x的数放在左右两边都是可以的。因为随着递归两边等于x的数会慢慢趋向中间
            do {
                rr--;
            }
            while (arr[rr] > x);
            if (ll < rr) {
                swap(arr, ll, rr);
            }
        }
        quick_sort(arr, l, rr);//分界点如果选择arr[l]则这里需要用rr
        quick_sort(arr, rr + 1, r);

    }

    public static void charu(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            int j = i;
            while (j > 0 && cur < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = cur;
        }
    }

    public static void maopao(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        //                int[] arr = new int[] {3, 21, 2, 3, 5, 6, 7, 86, 5, 4, 1, 2, 45,};
        int[] arr = new int[] {2, 3, 1};
        //        maopao(arr);
        //        charu(arr);
        quick_sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }


    }

    public static void swap(int[] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }


}
