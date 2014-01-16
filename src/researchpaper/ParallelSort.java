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
    private int choice;

    public ParallelSort(int[] arr, int numOfThreads, int choice) {
        this.arr = arr;
        this.numOfThreads = numOfThreads;
        this.choice = choice;
    }

    public void sort() {
        this.start();
        while (this.isAlive());
    }

    public void run() {
        sortdispatcher = new SortDispatcher(arr, numOfThreads, choice);
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
