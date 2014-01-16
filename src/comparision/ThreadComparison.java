package comparision;

import java.util.*;
import java.io.*;
import researchpaper.*;

public class ThreadComparison {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ThreadComparison cobj1 = new ThreadComparison();
        int maxCores = Runtime.getRuntime().availableProcessors();
        Scanner s = new Scanner(new FileReader(new File("input")));
        int n = s.nextInt();
        int m = s.nextInt();
        s.close();
        int numOfCores = 1;
        int choice = 0;
        File f = new File("output");
        if (f.exists()) {
            f.delete();
        }
        for (numOfCores = 1; numOfCores <= maxCores; numOfCores++) {
            long psqt = 0, qst = 0, mst = 0, psmt = 0;
            BufferedWriter out = new BufferedWriter(new FileWriter(f, true));
            for (int i = 0; i < m; i++) {
                int a[] = new int[n];
                int b[] = new int[n];
                int c[] = new int[n];
                int d[] = new int[n];
                choice = 0;
                ParallelSort ps1 = new ParallelSort(a, numOfCores, choice);
                QuickSort qs1 = new QuickSort();
                MergeSort ms1 = new MergeSort();
                cobj1.fillArray(a, 10 * n);
                cobj1.copyArray(b, a);
                cobj1.copyArray(c, a);
                cobj1.copyArray(d, a);
                long pss = System.currentTimeMillis();
                ps1.sort();
                long pse = System.currentTimeMillis();
                psqt = psqt + pse - pss;
                choice = 1;
                ps1 = new ParallelSort(d, numOfCores, choice);
                pss = System.currentTimeMillis();
                ps1.sort();
                pse = System.currentTimeMillis();
                psmt = psmt + pse - pss;
                long qss = System.currentTimeMillis();
                qs1.quickSort(b, 0, b.length - 1);
                long qse = System.currentTimeMillis();
                qst = qst + qse - qss;
                long mss = System.currentTimeMillis();
                ms1.mergeSort(c, 0, c.length - 1);
                long mse = System.currentTimeMillis();
                mst = mst + mse - mss;
                System.gc();
            }
            out.write("NumOfThreads: " + numOfCores + "\n");
            out.write("Parallel Sort(QuickSort): " + (psqt / m) + "\n");
            out.write("Parallel Sort(MergeSort): " + (psmt / m) + "\n");
            out.write("Quick Sort: " + (qst / m) + "\n");
            out.write("Merge Sort: " + (mst / m) + "\n");
            out.write("-------------------------------------------------\n");
            out.close();
        }
    }

    public void fillArray(int[] arr, int range) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * range);
        }
    }

    public void copyArray(int[] dest, int[] src) {
        for (int i = 0; i < src.length; i++) {
            dest[i] = src[i];
        }
    }
}
