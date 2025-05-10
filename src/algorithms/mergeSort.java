package algorithms;

public class mergeSort {

    public static void mergeSrt(int[] arr) {
        divThre(arr, 0, arr.length - 1);
    }

    public static void divThre(int[] arr, int si, int ei) {
        if (ei - si < 2) {
            return;
        }

        int total = ei - si + 1;
        int part = total / 3;
        int rem = total % 3;

        // int extra1 = 0;
        // int extra2 = 0;
        // if (rem > 0) {
        //     extra1 = 1;
        // }
        // if (rem > 1) {
        //     extra2 = 1;
        // }
        // int mid1 = si + part + extra1 - 1;
        // int mid2 = mid1 + part + extra2;

        int mid1 = si + part + (rem > 0 ? 1 : 0) - 1;
        int mid2 = mid1 + part + (rem > 1 ? 1 : 0);


        divThre(arr, si, mid1);
        divThre(arr, mid1 + 1, mid2);
        divThre(arr, mid2 + 1, ei);

        merge(arr, si, mid1, mid2, ei);
    }

    private static void divThre(double[] arr, int si, int ei) {
        if (ei - si < 2) return;

        int total = ei - si + 1;
        int part  = total / 3;
        int rem   = total % 3;
        int mid1  = si + part + (rem > 0 ? 1 : 0) - 1;
        int mid2  = mid1 + part + (rem > 1 ? 1 : 0);

        divThre(arr, si, mid1);
        divThre(arr, mid1 + 1, mid2);
        divThre(arr, mid2 + 1, ei);
        merge(arr, si, mid1, mid2, ei);
    }

    public static void merge(int[] arr, int si, int mid1, int mid2, int ei) {
        int[] left = new int[mid1 - si + 1];
        int[] middle = new int[mid2 - mid1];
        int[] right = new int[ei - mid2];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[si + i];
        }
        for (int i = 0; i < middle.length; i++) {
            middle[i] = arr[mid1 + 1 + i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid2 + 1 + i];
        }

        int i = 0, j = 0, k = 0;
        int idx = si;

        while (i < left.length && j < middle.length && k < right.length) {
            if (left[i] <= middle[j]) {
                if (left[i] <= right[k]) {
                    arr[idx++] = left[i++];
                } else {
                    arr[idx++] = right[k++];
                }
            } else {
                if (middle[j] <= right[k]) {
                    arr[idx++] = middle[j++];
                } else {
                    arr[idx++] = right[k++];
                }
            }
        }

        while (i < left.length && j < middle.length) {
            if (left[i] <= middle[j]) {
                arr[idx++] = left[i++];
            } else {
                arr[idx++] = middle[j++];
            }
        }

        while (j < middle.length && k < right.length) {
            if (middle[j] <= right[k]) {
                arr[idx++] = middle[j++];
            } else {
                arr[idx++] = right[k++];
            }
        }

        while (i < left.length && k < right.length) {
            if (left[i] <= right[k]) {
                arr[idx++] = left[i++];
            } else {
                arr[idx++] = right[k++];
            }
        }

        while (i < left.length) {
            arr[idx++] = left[i++];
        }

        while (j < middle.length) {
            arr[idx++] = middle[j++];
        }

        while (k < right.length) {
            arr[idx++] = right[k++];
        }
    }

    private static void merge(double[] arr, int si, int mid1, int mid2, int ei) {
        double[] temp = new double[ei - si + 1];
        int i = si, j = mid1 + 1, k = mid2 + 1, t = 0;

        while (i <= mid1 && j <= mid2 && k <= ei) {
            if (arr[i] <= arr[j] && arr[i] <= arr[k]) temp[t++] = arr[i++];
            else if (arr[j] <= arr[i] && arr[j] <= arr[k]) temp[t++] = arr[j++];
            else temp[t++] = arr[k++];
        }
        while (i <= mid1 && j <= mid2) temp[t++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
        while (j <= mid2 && k <= ei) temp[t++] = (arr[j] <= arr[k]) ? arr[j++] : arr[k++];
        while (i <= mid1 && k <= ei) temp[t++] = (arr[i] <= arr[k]) ? arr[i++] : arr[k++];
        while (i <= mid1) temp[t++] = arr[i++];
        while (j <= mid2) temp[t++] = arr[j++];
        while (k <= ei) temp[t++] = arr[k++];

        System.arraycopy(temp, 0, arr, si, temp.length);
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    public static void sort(int[] arr) {
        mergeSrt(arr);
    }

    public static void sort(double[] arr) {
        divThre(arr, 0, arr.length - 1);
    }


    public static void main(String[] args) {

        int[] test1 = {45, 23, 78, 12, 99, 34, 7, 56, 89, 3};
        System.out.println("Original array 1:");
        printArray(test1);
        mergeSrt(test1);
        System.out.println("Sorted array 1:");
        printArray(test1);
    
        int[] test2 = {5, 2, 9, 1, 6, 3, 8, 4, 7};
        System.out.println("\nOriginal array 2:");
        printArray(test2);
        mergeSrt(test2);
        System.out.println("Sorted array 2:");
        printArray(test2);
    
        int[] test3 = {10, 20, 30, 40, 50, 60};
        System.out.println("\nOriginal array 3:");
        printArray(test3);
        mergeSrt(test3);
        System.out.println("Sorted array 3:");
        printArray(test3);
    }
    
}
