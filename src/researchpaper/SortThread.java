/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package researchpaper;

/**
 *
 * @author aditya
 */
public class SortThread extends Thread implements Printable, SortThreadCompleteNotifier {

    private int[] arr;
    private int start;
    private int end;
    private Sort sobj1;

    public SortThread(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        sobj1 = new Sort();
    }

    public void run() {
        try {
            sobj1.sort(arr, start, end);
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

    public void addListener(SortThreadCompleteListener listener) {
        listeners.add(listener);
    }

    public void removeListener(SortThreadCompleteListener listener) {
        listeners.remove(listener);
    }

    public void notifyListeners() {
        for (SortThreadCompleteListener l : listeners) {
            l.notifyOnThreadComplete(this);
        }
    }
}
