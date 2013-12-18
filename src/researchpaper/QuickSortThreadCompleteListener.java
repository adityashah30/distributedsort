/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package researchpaper;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *
 * @author aditya
 */
public interface QuickSortThreadCompleteListener {

    Set<QuickSortThread> runningThreads = new CopyOnWriteArraySet<QuickSortThread>();

    public void notifyOnThreadComplete(QuickSortThread thread);

    public void addSource(QuickSortThread thread);

    public void removeSource(QuickSortThread thread);

    public boolean allThreadsfinished();
}
