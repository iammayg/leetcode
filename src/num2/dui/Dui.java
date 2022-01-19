package num2.dui;


import java.util.Scanner;

public class Dui {
    /**
     * 最小堆
     * 1.插入一个数 heap[++size] =x; up(size);
     * 2.求集合中最小值 heap[1];
     * 3.删除最小值 heap[1]=heap[size]; size--; down[1];
     * 4.删除任意一个元素 heap[k]=heap[size];size--; down(k); up(k); heap[k]可能变大也可能变小
     * 5.修改任意一个元素 heap(k)=x; down(k); up(k)
     */
    static int N = 1000000010;
    static int[] heap = new int[N];
    static int size = 0;


    static void insert(int x) {
        heap[++size] = x;
        up(size);
    }

    static int min() {
        return heap[1];
    }

    static void deleteMin() {
        heap[1] = heap[size];
        size--;
        down(1);
    }

    static void delete(int k) {
        heap[k] = heap[size];
        size--;
        down(k);
        up(k);
    }

    static void modify(int k, int x) {
        heap[k] = x;
        down(k);
        up(k);
    }

    static void up(int k) {
        while (k / 2 >= 1 && heap[k] < heap[k / 2]) {
            swap(heap, k, k / 2);
            k /= 2;
        }
    }

    static void down(int k) {
        while (2 * k <= size) {
            int nk;
            if (2 * k + 1 > size) {
                nk = 2 * k;
            } else {
                nk = heap[2 * k] < heap[2 * k + 1] ? 2 * k : 2 * k + 1;
            }
            if (heap[nk] >= heap[k]) {
                break;
            }
            swap(heap, k, nk);
            k = nk;
        }
    }

    static void swap(int[] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        for (int i = 0; i < n; i++) {
            heap[i+1]=in.nextInt();
        }
        size=n;
        for (int i = n/2; i >0; i--) {
            down(i);
        }

        for (int i = 1; i <= m; i++) {
            System.out.print(heap[1] + " ");
            deleteMin();
        }


    }

}
