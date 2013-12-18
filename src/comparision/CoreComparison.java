package comparision;

import java.util.*;
import java.io.*;
import researchpaper.*;

public class CoreComparison {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        CoreComparison cobj1 = new CoreComparison();
        int maxCores = Runtime.getRuntime().availableProcessors();
        Scanner s = new Scanner(new FileReader(new File("input")));
        int n = s.nextInt();
        int m = s.nextInt();
        s.close();
        int numOfCores = 1;
        File f = new File("output");
        if (f.exists()) {
            f.delete();
        }
        for (numOfCores = 1; numOfCores <= maxCores; numOfCores++) {
            long pst = 0, qst = 0, mst = 0, ast = 0;
            BufferedWriter out = new BufferedWriter(new FileWriter(f, true));
            for (int i = 0; i < m; i++) {
                int a[] = new int[n];
                int b[] = new int[n];
                int c[] = new int[n];
                int d[] = new int[n];
                ParallelSort ps1 = new ParallelSort(a, numOfCores);
                QuickSort qs1 = new QuickSort();
                MergeSort ms1 = new MergeSort();
                cobj1.fillArray(a, 10 * n);
                cobj1.copyArray(b, a);
                cobj1.copyArray(c, a);
                cobj1.copyArray(d, a);
                long pss = System.currentTimeMillis();
                ps1.sort();
                long pse = System.currentTimeMillis();
                pst = pst + pse - pss;
                long qss = System.currentTimeMillis();
                qs1.quickSort(b, 0, b.length - 1);
                long qse = System.currentTimeMillis();
                qst = qst + qse - qss;
                long mss = System.currentTimeMillis();
                ms1.mergeSort(c, 0, c.length - 1);
                long mse = System.currentTimeMillis();
                mst = mst + mse - mss;
                long ass = System.currentTimeMillis();
                Arrays.sort(d, 0, d.length - 1);
                long ase = System.currentTimeMillis();
                ast = ast + ase - ass;
                System.gc();
            }
            out.write("NumOfCores: " + numOfCores + " Parallel Sort: " + (pst / m) + "\n");
            out.write("NumOfCores: " + numOfCores + " Quick Sort: " + (qst / m) + "\n");
            out.write("NumOfCores: " + numOfCores + " Merge Sort: " + (mst / m) + "\n");
            out.write("NumOfCores: " + numOfCores + " Arrays Sort: " + (ast / m) + "\n");
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
