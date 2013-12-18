/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package researchpaper;

/**
 *
 * @author aditya
 */
public class QuickSortDispatcher implements QuickSortThreadCompleteListener {

    private int[] arr;
    private int numOfThreads;
    private QuickSortThread[] sortThreads;

    public QuickSortDispatcher(int[] arr, int numOfThreads) {
        this.arr = arr;
        this.numOfThreads = numOfThreads;
        sortThreads = new QuickSortThread[numOfThreads];
    }

    public void dispatch() {
        for (int i = 0; i < numOfThreads; i++) {
            if (i < numOfThreads - 1) {
                sortThreads[i] = new QuickSortThread(arr, (i * arr.length) / numOfThreads, ((i + 1) * arr.length) / numOfThreads - 1);
            } else {
                sortThreads[i] = new QuickSortThread(arr, (i * arr.length) / numOfThreads, arr.length - 1);
            }
            this.addSource(sortThreads[i]);
            sortThreads[i].addListener(this);
            sortThreads[i].start();
        }
        while (!allThreadsfinished());
    }

    public synchronized void notifyOnThreadComplete(QuickSortThread thread) {
        this.removeSource(thread);
    }

    public void addSource(QuickSortThread thread) {
        runningThreads.add(thread);
    }

    public void removeSource(QuickSortThread thread) {
        runningThreads.remove(thread);
    }

    public boolean allThreadsfinished() {
        return runningThreads.isEmpty();
    }
}
