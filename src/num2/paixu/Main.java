package num2.paixu;


import java.util.Scanner;

public class Main {


    static int[] temp = new int[10000];

    static void guibing(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;

        guibing(arr, l, mid);
        guibing(arr, mid + 1, r);

        int k = 0;

        int i = l;
        int j = mid + 1;
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= r) {
            temp[k++] = arr[j++];
        }
        for (i = l, j = 0; i <= r; i++, j++) {
            arr[i] = temp[j];
        }
    }


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
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        guibing(arr, 0, n - 1);
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
