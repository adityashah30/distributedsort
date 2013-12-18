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
public interface SortThreadCompleteNotifier {

    Set<SortThreadCompleteListener> listeners = new CopyOnWriteArraySet<SortThreadCompleteListener>();

    public void addListener(SortThreadCompleteListener listener);

    public void removeListener(SortThreadCompleteListener listener);

    public void notifyListeners();
}
