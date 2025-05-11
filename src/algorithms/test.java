package algorithms;

import java.io.*;
import java.util.*;

public class test {

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int[] copyArray(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    public static Map<String, int[]> readLabeledInput(String filename) throws IOException {
        Map<String, int[]> testCases = new LinkedHashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = reader.readLine()) != null) {
            if (!line.trim().isEmpty() && line.contains(":")) {
                String[] parts = line.split(":");
                String label = parts[0].trim();
                String[] nums = parts[1].trim().split("\\s+");

                int[] arr = new int[nums.length];
                for (int i = 0; i < nums.length; i++) {
                    arr[i] = Integer.parseInt(nums[i]);
                }
                testCases.put(label, arr);
            }
        }

        reader.close();
        return testCases;
    }



    public static void main(String[] args) throws IOException {
        String filePath = "src/input/input.txt";
        Map<String, int[]> testCases = readLabeledInput(filePath);

        for (Map.Entry<String, int[]> entry : testCases.entrySet()) {
            String label = entry.getKey();
            int[] original = entry.getValue();

            System.out.println(label + ":");
            System.out.print("Original:  ");
            printArray(original);

            int[] arr1 = copyArray(original);
            int[] arr2 = copyArray(original);
            int[] arr3 = copyArray(original);
            int[] arr4 = copyArray(original);

            System.out.print("TimSort:   ");
            timSol.sort(arr1);
            printArray(arr1);

            System.out.print("QuickSort: ");
            RandomQuickSort.sort(arr2);
            printArray(arr2);

            System.out.print("MergeSort: ");
            mergeSort.sort(arr3);
            printArray(arr3);

            System.out.print("HeapSort:  ");
            SolutionHeap.sort(arr4);
            printArray(arr4);

            System.out.println("\n");
            System.out.println("\n");
        }
    }
}
