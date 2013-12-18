/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package researchpaper;

/**
 *
 * @author aditya
 */
public class ParallelSort extends Thread implements Printable {

    private SortDispatcher sortdispatcher;
    private MergeDispatcher mergedispatcher;
    private int[] arr;
    private int numOfThreads;

    public ParallelSort(int[] arr, int numOfThreads) {
        this.arr = arr;
        this.numOfThreads = numOfThreads;
    }

    public void sort() {
        this.start();
        while (this.isAlive());
    }

    public void run() {
        sortdispatcher = new SortDispatcher(arr, numOfThreads);
        sortdispatcher.dispatch();
        mergedispatcher = new MergeDispatcher(arr, numOfThreads);
        mergedispatcher.dispatch();
    }

    public void printArray() {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
