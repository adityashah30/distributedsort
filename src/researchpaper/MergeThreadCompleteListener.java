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
public interface MergeThreadCompleteListener {

    Set<MergeThread> runningThreads = new CopyOnWriteArraySet<MergeThread>();

    public void notifyOnThreadComplete(MergeThread thread);

    public void addSource(MergeThread thread);

    public void removeSource(MergeThread thread);

    public boolean allThreadsfinished();
}
