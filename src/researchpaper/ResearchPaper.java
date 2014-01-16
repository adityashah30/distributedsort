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
        ResearchPaper rpobj1 = new ResearchPaper();
        int size = 10000000;
        int a[] = new int[size];
        rpobj1.fillRandom(a, size);
        int numOfChunks = 4;
        ParallelSort psort1 = new ParallelSort(a, numOfChunks, 0);
        //psort1.printArray();
        psort1.sort();
        System.out.println(rpobj1.isSorted(a));
        //psort1.printArray();
    }

    public void fillRandom(int[] arr, int range) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * range);
        }
    }

    public boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
