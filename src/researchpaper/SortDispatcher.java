/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package researchpaper;

/**
 *
 * @author aditya
 */
public class SortDispatcher implements SortThreadCompleteListener {

    private int[] arr;
    private int numOfThreads;
    private int choice;
    private SortThread[] sortThreads;

    public SortDispatcher(int[] arr, int numOfThreads, int choice) {
        this.arr = arr;
        this.numOfThreads = numOfThreads;
        this.choice = choice;
        sortThreads = new SortThread[numOfThreads];
    }

    public void dispatch() {
        for (int i = 0; i < numOfThreads; i++) {
            if (i < numOfThreads - 1) {
                sortThreads[i] = new SortThread(arr, (i * arr.length) / numOfThreads, ((i + 1) * arr.length) / numOfThreads - 1, choice);
            } else {
                sortThreads[i] = new SortThread(arr, (i * arr.length) / numOfThreads, arr.length - 1, choice);
            }
            this.addSource(sortThreads[i]);
            sortThreads[i].addListener(this);
            sortThreads[i].start();
        }
        while (!allThreadsfinished());
    }

    public synchronized void notifyOnThreadComplete(SortThread thread) {
        this.removeSource(thread);
    }

    public void addSource(SortThread thread) {
        runningThreads.add(thread);
    }

    public void removeSource(SortThread thread) {
        runningThreads.remove(thread);
    }

    public boolean allThreadsfinished() {
        return runningThreads.isEmpty();
    }
}
