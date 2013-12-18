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
public interface QuickSortThreadCompleteNotifier {

    Set<QuickSortThreadCompleteListener> listeners = new CopyOnWriteArraySet<QuickSortThreadCompleteListener>();

    public void addListener(QuickSortThreadCompleteListener listener);

    public void removeListener(QuickSortThreadCompleteListener listener);

    public void notifyListeners();
}
