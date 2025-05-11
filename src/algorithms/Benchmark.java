package algorithms;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Benchmark {

    static final int R = 5;

    // static final int[] POWERS = {
    //     20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30
    // };

    static final int[] POWERS = {
        20, 21, 22, 23, 24, 25, 26
    };

    static final String[] TYPES = {"int", "double"};
    static final String[] ALGORITHMS = {
        "QuadHeap", "ThreeWayMerge", "QuickSort", "TimSort"
    };

    public static void main(String[] args) throws IOException {
        try (FileWriter writer = new FileWriter("benchmark_results.csv")) {
            // Header matches the five values below
            writer.write("algorithm,input_type,input_size,avg_ns,avg_ms\n");

            for (String type : TYPES) {
                for (int p : POWERS) {
                    int n = 1 << p;              

                    for (String algo : ALGORITHMS) {
                        long sumNs = 0;

                        for (int t = 0; t < R; t++) {
                            if (type.equals("int")) {
                                int[] data = randomInts(n);
                                int[] copy = Arrays.copyOf(data, n);
                                long t0 = System.nanoTime();
                                runSort(algo, copy);
                                sumNs += System.nanoTime() - t0;
                            } else {
                                double[] data = randomDoubles(n);
                                double[] copy = Arrays.copyOf(data, n);
                                long t0 = System.nanoTime();
                                runSort(algo, copy);
                                sumNs += System.nanoTime() - t0;
                            }
                        }

                        long avgNs = sumNs / R;
                        double avgMs = avgNs / 1_000_000.0;

                        writer.write(String.format(
                            "%s,%s,%d,%d,%.3f\n",
                            algo,    // algorithm name
                            type,    // "int" or "double"
                            n,       // input size
                            avgNs,   // average nanoseconds
                            avgMs    // average milliseconds
                        ));

                        System.out.printf(
                            "%s %s 2^%d → avg %.0fµs (%.3fms)%n",
                            algo, type, p, avgNs / 1_000.0, avgMs
                        );
                    }
                }
            }
        }

        System.out.println("Completed. Check benchmark_results.csv");
    }

    static void runSort(String algo, int[] arr) {
        switch (algo) {
            case "QuadHeap":      SolutionHeap.sort(arr);      break;
            case "ThreeWayMerge": mergeSort.sort(arr);         break;
            case "QuickSort":     RandomQuickSort.sort(arr);   break;
            case "TimSort":       timSol.sort(arr);            break;
        }
    }

    static void runSort(String algo, double[] arr) {
        switch (algo) {
            case "QuadHeap":      SolutionHeap.sort(arr);      break;
            case "ThreeWayMerge": mergeSort.sort(arr);         break;
            case "QuickSort":     RandomQuickSort.sort(arr);   break;
            case "TimSort":       timSol.sort(arr);            break;
        }
    }

    static int[] randomInts(int n) {
        Random r = new Random();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = r.nextInt();
        return a;
    }

    static double[] randomDoubles(int n) {
        Random r = new Random();
        double[] a = new double[n];
        for (int i = 0; i < n; i++) a[i] = r.nextDouble();
        return a;
    }
}
