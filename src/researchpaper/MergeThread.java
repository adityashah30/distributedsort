/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package researchpaper;

/**
 *
 * @author aditya
 */
public class MergeThread extends Thread implements Printable, MergeThreadCompleteNotifier {

    private int[] arr;
    private int start1, end1, start2, end2, start3, end3;
    private Merger mobj1;

    public MergeThread(int[] arr, int start1, int end1, int start2, int end2) {
        this.arr = arr;
        this.start1 = start1;
        this.end1 = end1;
        this.start2 = start2;
        this.end2 = end2;
        this.start3 = -1;
        this.end3 = -1;
        mobj1 = new Merger();
    }

    public MergeThread(int[] arr, int start1, int end1, int start2, int end2, int start3, int end3) {
        this.arr = arr;
        this.start1 = start1;
        this.end1 = end1;
        this.start2 = start2;
        this.end2 = end2;
        this.start3 = start3;
        this.end3 = end3;
        mobj1 = new Merger();
    }

    public void run() {
        try {
            if (start3 == -1 && end3 == -1) {
                mobj1.merge(arr, start1, end1, start2, end2);
            } else {
                mobj1.merge(arr, start1, end1, start2, end2, start3, end3);
            }
        } finally {
            notifyListeners();
        }
    }

    public void printArray() {
        for (int i = start1; i <= end1; i++) {
            System.out.print(arr[i] + " ");
        }
        for (int i = start2; i <= end2; i++) {
            System.out.print(arr[i] + " ");
        }
        if (start3 != -1 && end3 != -1) {
            for (int i = start3; i <= end3; i++) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    public void addListener(MergeThreadCompleteListener listener) {
        listeners.add(listener);
    }

    public void removeListener(MergeThreadCompleteListener listener) {
        listeners.remove(listener);
    }

    public void notifyListeners() {
        for (MergeThreadCompleteListener l : listeners) {
            l.notifyOnThreadComplete(this);
        }
    }
}
