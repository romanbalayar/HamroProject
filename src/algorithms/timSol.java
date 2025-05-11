package algorithms;

public class timSol {

    public static final int RUN = 32;

    public static void insertionSort(int[] arr, int si, int ei) {
        for (int i = si + 1; i <= ei; i++) {
            int curr = arr[i];
            int prev = i - 1;

            while (prev >= si && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = curr;
        }
    }

    public static void merge(int[] arr, int si, int mid, int ei) {
        int[] temp = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void timSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i += RUN) {
            int end = Math.min(i + RUN - 1, n - 1);
            insertionSort(arr, i, end);
        }

        for (int size = RUN; size < n; size = 2 * size) {
            for (int si = 0; si < n; si += 2 * size) {
                int mid = si + size - 1;
                int ei = Math.min(si + 2 * size - 1, n - 1);

                if (mid < ei) {
                    merge(arr, si, mid, ei);
                }
            }
        }
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void sort(int[] arr) {
        timSort(arr);
    }

    public static void sort(double[] arr) {
        int[] tmp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = (int) arr[i];
        }
        sort(tmp);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tmp[i];
        }
    }

//    public static void main(String[] args) {
//        int[] arr = { 10, 3, 2, 19, 7, 15, 23, 13, 1 };
//
//        System.out.println("Original array:");
//        printArr(arr);
//
//        timSort(arr);
//
//        System.out.println("\nSorted array:");
//        printArr(arr);
//    }


}
