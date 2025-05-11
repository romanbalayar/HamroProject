package algorithms;

public class SolutionHeap {
    
    private static void heapifySort(int[] heap, int i, int heapSize) {
        int maxIndex = i;

        for (int k = 1; k <= 4; k++) {
            int child = 4 * i + k;
            if (child < heapSize && heap[child] > heap[maxIndex]) {
                maxIndex = child;
            }
        }

        if (maxIndex != i) {
            int temp = heap[i];
            heap[i] = heap[maxIndex];
            heap[maxIndex] = temp;
            heapifySort(heap, maxIndex, heapSize);
        }
    }

    public static void HeapSort(Heap heap) {
        int[] arr = heap.getHeapArray();
        int size = heap.size();

        for (int i = (size - 1) / 4; i >= 0; i--) {
            heapifySort(arr, i, size);
        }

        for (int i = size - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapifySort(arr, 0, i);
        }
        heap.setSize(size);
    }

    public static void sort(int[] arr) {
        Heap heap = new Heap(arr.length);
        for (int num : arr) {
            heap.add(num);
        }
        HeapSort(heap);
        int[] sorted = heap.getHeapArray();
        System.arraycopy(sorted, 0, arr, 0, arr.length);
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

    static class Heap {
        private final int[] heap;
        private int size;

        public Heap(int capacity) {
            heap = new int[capacity];
            size = 0;
        }

        public void add(int data) {
            if (size == heap.length) {
                System.out.println("Heap is full");
                return;
            }

            heap[size] = data;
            heapifyforAdd(size);
            size++;
        }

        private void heapifyforAdd(int i) {
            int child = i;
            int parent = (child - 1) / 4;

            while (child > 0 && heap[child] < heap[parent]) {
                swap(child, parent);
                child = parent;
                parent = (child - 1) / 4;
            }
        }

        public int peek() {
            if (size == 0) {
                System.out.println("Heap is empty");
                return -1;
            }
            return heap[0];
        }

        public int remove() {
            if (size == 0) {
                System.out.println("Heap is empty");
                return -1;
            }

            int min = heap[0];
            heap[0] = heap[size - 1];
            size--;
            heapifyForRemove(0);
            return min;
        }
        
        private void heapifyForRemove(int i) {
            int minIndex = i;

            for (int k = 1; k <= 4; k++) {
                int child = 4 * i + k;
                if (child < size && heap[child] < heap[minIndex]) {
                    minIndex = child;
                }
            }

            if (minIndex != i) {
                swap(i, minIndex);
                heapifyForRemove(minIndex);
            }
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        int[] getHeapArray() {
            return heap;
        }

        void setSize(int newSize) {
            this.size = newSize;
        }

        public void print() {
            System.out.print("Heap: ");
            for (int i = 0; i < size; i++) {
                System.out.print(heap[i] + " ");
            }
            System.out.println();
        }
    }



//    public static void main(String[] args) {
//        System.out.println("Testing Quad Heap Operations:");
//        Heap heap = new Heap(10);
//
//        heap.add(5);
//        heap.add(3);
//        heap.add(8);
//        heap.add(1);
//        heap.add(2);
//        heap.add(7);
//        heap.add(6);
//        heap.add(4);
//
//        System.out.print("insertions of ");
//        heap.print();
//
//        System.out.print("Removing  elements: ");
//        while (!heap.isEmpty()) {
//            System.out.print( heap.remove() + " ");
//        }
//        System.out.println();
//
//        System.out.println("\nTesting Heap Sort ");
//
//        int[] arr = {12, 11, 13, 5, 6, 7, 3, 2, 8};
//        Heap sortHeap = new Heap(arr.length);
//        for (int num : arr) {
//            sortHeap.add(num);
//        }
//
//        System.out.print("Original array ");
//        sortHeap.print();
//
//        HeapSort(sortHeap);
//        System.out.print("Sorted arr  of ");
//        sortHeap.print();
//    }


}