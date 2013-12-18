/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package researchpaper;

/**
 *
 * @author aditya
 */
import java.util.LinkedList;

public class MergeDispatcher implements MergeThreadCompleteListener {

    private int numOfChunks;
    private int numOfThreads;
    private int[] arr;
    private boolean oddFlag;
    private MergeThread[] mergeThreads;
    private LinkedList<Integer> markerList;

    public MergeDispatcher(int[] arr, int numOfChunks) {
        this.arr = arr;
        this.numOfChunks = numOfChunks;
        this.numOfThreads = numOfChunks / 2;
        this.markerList = new LinkedList<Integer>();
    }

    public void dispatch() {
        fillMarkerList();
        for (numOfThreads = numOfChunks / 2; numOfThreads > 0; numOfThreads /= 2, numOfChunks /= 2) {
            if (numOfChunks % 2 == 1) {
                oddFlag = true;
            } else {
                oddFlag = false;
            }
            mergeThreads = new MergeThread[numOfThreads];
            for (int i = 0; i < numOfThreads; i++) {
                if (i < numOfThreads - 1) {
                    int s1 = markerList.removeFirst();
                    int e1 = markerList.removeFirst();
                    int s2 = markerList.removeFirst();
                    int e2 = markerList.removeFirst();
                    markerList.addLast(s1);
                    markerList.addLast(e2);
                    mergeThreads[i] = new MergeThread(arr, s1, e1, s2, e2);
                } else if (i == numOfThreads - 1) {
                    if (oddFlag) {
                        int s1 = markerList.removeFirst();
                        int e1 = markerList.removeFirst();
                        int s2 = markerList.removeFirst();
                        int e2 = markerList.removeFirst();
                        int s3 = markerList.removeFirst();
                        int e3 = markerList.removeFirst();
                        markerList.addLast(s1);
                        markerList.addLast(e3);
                        mergeThreads[i] = new MergeThread(arr, s1, e1, s2, e2, s3, e3);
                    } else {
                        int s1 = markerList.removeFirst();
                        int e1 = markerList.removeFirst();
                        int s2 = markerList.removeFirst();
                        int e2 = markerList.removeFirst();
                        markerList.addLast(s1);
                        markerList.addLast(e2);
                        mergeThreads[i] = new MergeThread(arr, s1, e1, s2, e2);
                    }
                }
                this.addSource(mergeThreads[i]);
                mergeThreads[i].addListener(this);
                mergeThreads[i].start();
            }
            while (!allThreadsfinished());
        }
    }

    public void fillMarkerList() {
        if (numOfChunks % 2 == 1) {
            oddFlag = true;
        } else {
            oddFlag = false;
        }
        for (int i = 0; i < numOfChunks / 2; i++) {
            if (i < numOfChunks / 2 - 1) {
                markerList.addLast((2 * i * arr.length) / numOfChunks);
                markerList.addLast(((2 * i + 1) * arr.length) / numOfChunks - 1);
                markerList.addLast(((2 * i + 1) * arr.length) / numOfChunks);
                markerList.addLast(((2 * i + 2) * arr.length) / numOfChunks - 1);
            } else if (i == numOfChunks / 2 - 1) {
                markerList.addLast((2 * i * arr.length) / numOfChunks);
                markerList.addLast(((2 * i + 1) * arr.length) / numOfChunks - 1);
                if (oddFlag) {
                    markerList.addLast(((2 * i + 1) * arr.length) / numOfChunks);
                    markerList.addLast(((2 * i + 2) * arr.length) / numOfChunks - 1);
                    markerList.addLast(((2 * i + 2) * arr.length) / numOfChunks);
                    markerList.addLast(arr.length - 1);
                } else {
                    markerList.addLast(((2 * i + 1) * arr.length) / numOfChunks);
                    markerList.addLast(arr.length - 1);
                }
            }
        }
    }

    public synchronized void notifyOnThreadComplete(MergeThread thread) {
        this.removeSource(thread);
    }

    public void addSource(MergeThread thread) {
        runningThreads.add(thread);
    }

    public void removeSource(MergeThread thread) {
        runningThreads.remove(thread);
    }

    public boolean allThreadsfinished() {
        return runningThreads.isEmpty();
    }
}
