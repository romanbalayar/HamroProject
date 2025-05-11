package algorithms;

public class RandomQuickSort {


//    public static void printArr(int arr[]) {
//        for(int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//    }


    public static void quickSort(int arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }
        
        int pIdx = randomizedPartition(arr, si, ei);
        quickSort(arr, si, pIdx - 1);
        quickSort(arr, pIdx + 1, ei);
    }

    private static void quickSort(double[] arr, int si, int ei) {
        if (si >= ei) return;
        int p = randomizedPartition(arr, si, ei);
        quickSort(arr, si, p - 1);
        quickSort(arr, p + 1, ei);
    }


    public static int randomizedPartition(int arr[], int si, int ei) {
    
        int randomPivotIndex = si + (int)(Math.random() * (ei - si + 1));
        
        int temp = arr[randomPivotIndex];
        arr[randomPivotIndex] = arr[ei];
        arr[ei] = temp;
        
        return partition(arr, si, ei);
    }

    private static int randomizedPartition(double[] arr, int si, int ei) {
        int pivotIdx = si + (int)(Math.random() * (ei - si + 1));
        double tmp = arr[pivotIdx];
        arr[pivotIdx] = arr[ei];
        arr[ei]       = tmp;
        return partition(arr, si, ei);
    }

    
    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;
        for(int j = si; j < ei; j++) {
            if(arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = arr[ei];
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    private static int partition(double[] arr, int si, int ei) {
        double pivot = arr[ei];
        int i = si - 1;
        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                double t = arr[i]; arr[i] = arr[j]; arr[j] = t;
            }
        }
        double t = arr[i + 1]; arr[i + 1] = arr[ei]; arr[ei] = t;
        return i + 1;
    }

    public static void sort(int A[]){
        quickSort(A, 0, A.length - 1);
    }

    public static void sort(double A[]){
        quickSort(A, 0, A.length - 1);
    }



//    public static void main(String[] args) {
//        int arr[] = {6, 3, 9, 8, 2, 5};
//        quickSort(arr, 0, arr.length - 1);
//        printArr(arr);
//    }


}