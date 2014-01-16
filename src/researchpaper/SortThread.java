package researchpaper;

/**
 * The SortThread Class is a thread implementation of the Sort Class. Creates a
 * thread. Implements the SortThreadCompleteNotifier interface.
 *
 * @author Aditya Shah
 */
public class SortThread extends Thread implements Printable, SortThreadCompleteNotifier {

    /**
     * The array to be sorted.
     */
    private int[] arr;
    /**
     * The starting index.
     */
    private int start;
    /**
     * The ending index.
     */
    private int end;
    /**
     * Object of class Sort.
     */
    private Sort sobj1;
    private int choice;

    /**
     *
     * @param arr The array to be sorted.
     * @param start The starting index.
     * @param end The ending index.
     */
    public SortThread(int[] arr, int start, int end, int choice) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.choice = choice;
        sobj1 = new Sort(choice);
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
