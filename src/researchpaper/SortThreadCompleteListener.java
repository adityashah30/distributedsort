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
public interface SortThreadCompleteListener {

    Set<SortThread> runningThreads = new CopyOnWriteArraySet<SortThread>();

    public void notifyOnThreadComplete(SortThread thread);

    public void addSource(SortThread thread);

    public void removeSource(SortThread thread);

    public boolean allThreadsfinished();
}
