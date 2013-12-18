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
public interface MergeThreadCompleteNotifier {

    Set<MergeThreadCompleteListener> listeners = new CopyOnWriteArraySet<MergeThreadCompleteListener>();

    public void addListener(MergeThreadCompleteListener listener);

    public void removeListener(MergeThreadCompleteListener listener);

    public void notifyListeners();
}
