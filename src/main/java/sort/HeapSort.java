package sort;

/**
 * Created by Suheng on 3/21/16.
 */
public class HeapSort {
    public static void main(String[] args) {
        heapSort(38, 49, 65, 97, 76, 13, 27, 4);
    }

    public static void heapSort(int... heap) {
        //创建堆
        buildingHead(heap);
        for (int i = heap.length - 1; i > 0; i--) {
            int tmp = heap[i];
            heap[i] = heap[0];
            heap[0] = tmp;
            headAdjust(heap, 0, i);
        }
        for (int i : heap) {
            System.out.print(i + " ");
        }
    }

    public static void buildingHead(int[] heap) {
        for (int i = (heap.length - 1) / 2; i >= 0; i--) {
            headAdjust(heap, i,heap.length);
        }

    }

    public static void headAdjust(int[] h, int i, int length) {
        int tmp = h[i];
        int child = 2 * i + 1;
        while (child < h.length) {
            if (child + 1 < h.length && h[child] < h[child + 1]) {
                child++;
            }

            if (h[i] < h[child]) {
                h[i] = h[child];
                i = child;
                child = 2 * i + 1;
            } else {
                break;
            }
            h[i] = tmp;

        }

    }
}
