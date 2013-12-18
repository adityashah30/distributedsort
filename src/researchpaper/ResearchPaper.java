/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package researchpaper;

/**
 *
 * @author aditya
 */
public class ResearchPaper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        int a[] = {1, 12, 2, 11, 3, 10, 4, 9, 5, 8, 6, 7};
        int numOfChunks = 4;
        ParallelSort psort1 = new ParallelSort(a, numOfChunks);
        psort1.printArray();
        psort1.sort();
        psort1.printArray();
    }
}
