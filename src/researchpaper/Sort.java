package researchpaper;

/**
 * The Sort class contains implementation of merge sort algorithm.
 *
 * @author Aditya Shah
 *
 */
public class Sort {

    /**
     * The sort function.
     *
     * @param a The array to be sorted.
     * @param start The starting index.
     * @param end The ending index.
     *
     */
    public void sort(int a[], int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(a, start, mid);
            sort(a, mid + 1, end);
            merge(a, start, mid, mid + 1, end);
        }
    }

    /**
     * The merge function. Takes two chunks of sorted data and combines them to
     * one chunk of sorted data.
     *
     * @param a The array to be merged.
     * @param start1 The starting index of first chunk.
     * @param end1 The ending index of the first chunk.
     * @param start2 The starting index of second chunk.
     * @param end2 The ending index of the second chunk.
     *
     */
    public void merge(int a[], int start1, int end1, int start2, int end2) {
        int temp[] = new int[end1 - start1 + end2 - start2 + 2];
        int ptr1 = start1, ptr2 = start2, ptrmain = 0;
        while (ptr1 <= end1 && ptr2 <= end2) {
            if (a[ptr1] < a[ptr2]) {
                temp[ptrmain++] = a[ptr1++];
            } else {
                temp[ptrmain++] = a[ptr2++];
            }
        }
        while (ptr1 <= end1) {
            temp[ptrmain++] = a[ptr1++];
        }
        while (ptr2 <= end2) {
            temp[ptrmain++] = a[ptr2++];
        }
        ptrmain = 0;
        for (int i = start1; i <= end1; i++) {
            a[i] = temp[ptrmain++];
        }
        for (int i = start2; i <= end2; i++) {
            a[i] = temp[ptrmain++];
        }
    }
}

/*public class Sort {

    public void sort(int[] a, int start, int end) {
        if (start < end) {
            int key = partitionArray(a, start, end);
            quickSort(a, start, key - 1);
            quickSort(a, key + 1, end);
        }
    }

    public int partitionArray(int[] arr, int start, int end) {
        int pivot = start + (int) (Math.random() * (end - start + 1));
        swapElement(arr, start, pivot);
        int key = arr[start];
        int i = start;
        for (int j = i + 1; j <= end; j++) {
            if (arr[j] < key) {
                i++;
                swapElement(arr, i, j);
            }

        }
        swapElement(arr, start, i);
        return i;
    }

    public void swapElement(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
*/
