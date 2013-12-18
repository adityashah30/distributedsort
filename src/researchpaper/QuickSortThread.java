/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package researchpaper;

/**
 *
 * @author aditya
 */
public class QuickSortThread extends Thread implements Printable, QuickSortThreadCompleteNotifier {

    private int[] arr;
    private int start;
    private int end;
    private QuickSort qobj1;

    public QuickSortThread(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        qobj1 = new QuickSort();
    }

    public void run() {
        try {
            qobj1.quickSort(arr, start, end);
        } finally {
            notifyListeners();
        }
    }

    public void printArray() {
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void addListener(QuickSortThreadCompleteListener listener) {
        listeners.add(listener);
    }

    public void removeListener(QuickSortThreadCompleteListener listener) {
        listeners.remove(listener);
    }

    public void notifyListeners() {
        for (QuickSortThreadCompleteListener l : listeners) {
            l.notifyOnThreadComplete(this);
        }
    }
}
