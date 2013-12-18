/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package researchpaper;

/**
 *
 * @author aditya
 */
import java.util.Arrays;

public class Merger {

    public void merge(int[] arr, int s1, int e1, int s2, int e2) {
        SwapResult swapRes = swap(s1, e1, s2, e2);
        s1 = swapRes.s1;
        s2 = swapRes.s2;
        e1 = swapRes.e1;
        e2 = swapRes.e2;
        int tempArray[] = new int[e2 + e1 - s1 - s2 + 2];
        int ptr1 = s1, ptr2 = s2, ptrmain = 0;
        while (ptr1 <= e1 && ptr2 <= e2) {
            if (arr[ptr1] <= arr[ptr2]) {
                tempArray[ptrmain++] = arr[ptr1++];
            } else {
                tempArray[ptrmain++] = arr[ptr2++];
            }
        }
        while (ptr1 <= e1) {
            tempArray[ptrmain++] = arr[ptr1++];
        }
        while (ptr2 <= e2) {
            tempArray[ptrmain++] = arr[ptr2++];
        }
        ptrmain = 0;
        ptr1 = s1;
        while (ptr1 <= e1) {
            arr[ptr1++] = tempArray[ptrmain++];
        }
        ptr2 = s2;
        while (ptr2 <= e2) {
            arr[ptr2++] = tempArray[ptrmain++];
        }
    }

    public void merge(int[] arr, int s1, int e1, int s2, int e2, int s3, int e3) {
        SwapResult swapRes = swap(s1, e1, s2, e2, s3, e3);
        s1 = swapRes.s1;
        s2 = swapRes.s2;
        s3 = swapRes.s3;
        e1 = swapRes.e1;
        e2 = swapRes.e2;
        e3 = swapRes.e3;
        int tempArray[] = new int[e3 + e2 + e1 - s3 - s2 - s1 + 3];
        int ptr1 = s1, ptr2 = s2, ptr3 = s3, ptrmain = 0;
        while (ptr1 <= e1 && ptr2 <= e2 && ptr3 <= e3) {
            int val1 = arr[ptr1];
            int val2 = arr[ptr2];
            int val3 = arr[ptr3];
            if (val1 <= val2) {
                if (val1 <= val3) {
                    tempArray[ptrmain++] = arr[ptr1++];
                } else {
                    tempArray[ptrmain++] = arr[ptr3++];
                }
            } else {
                if (val2 <= val3) {
                    tempArray[ptrmain++] = arr[ptr2++];
                } else {
                    tempArray[ptrmain++] = arr[ptr3++];
                }
            }
        }
        if (ptr1 == e1 + 1) {
            while (ptr2 <= e2 && ptr3 <= e3) {
                if (arr[ptr2] <= arr[ptr3]) {
                    tempArray[ptrmain++] = arr[ptr2++];
                } else {
                    tempArray[ptrmain++] = arr[ptr3++];
                }
            }
            while (ptr2 <= e2) {
                tempArray[ptrmain++] = arr[ptr2++];
            }
            while (ptr3 <= e3) {
                tempArray[ptrmain++] = arr[ptr3++];
            }
        } else if (ptr2 == e2 + 1) {
            while (ptr1 <= e1 && ptr3 <= e3) {
                if (arr[ptr1] <= arr[ptr3]) {
                    tempArray[ptrmain++] = arr[ptr1++];
                } else {
                    tempArray[ptrmain++] = arr[ptr3++];
                }
            }
            while (ptr1 <= e1) {
                tempArray[ptrmain++] = arr[ptr1++];
            }
            while (ptr3 <= e3) {
                tempArray[ptrmain++] = arr[ptr3++];
            }
        } else if (ptr3 == e3 + 1) {
            while (ptr1 <= e1 && ptr2 <= e2) {
                if (arr[ptr1] <= arr[ptr2]) {
                    tempArray[ptrmain++] = arr[ptr1++];
                } else {
                    tempArray[ptrmain++] = arr[ptr2++];
                }
            }
            while (ptr1 <= e1) {
                tempArray[ptrmain++] = arr[ptr1++];
            }
            while (ptr2 <= e2) {
                tempArray[ptrmain++] = arr[ptr2++];
            }
        }
        ptr1 = s1;
        ptr2 = s2;
        ptr3 = s3;
        ptrmain = 0;
        while (ptr1 <= e1) {
            arr[ptr1++] = tempArray[ptrmain++];
        }
        while (ptr2 <= e2) {
            arr[ptr2++] = tempArray[ptrmain++];
        }
        while (ptr3 <= e3) {
            arr[ptr3++] = tempArray[ptrmain++];
        }
    }

    public SwapResult swap(int s1, int e1, int s2, int e2) {
        return new SwapResult(s1, e1, s2, e2);
    }

    public SwapResult swap(int s1, int e1, int s2, int e2, int s3, int e3) {
        return new SwapResult(s1, e1, s2, e2, s3, e3);
    }
}

class SwapResult {

    int s1, e1, s2, e2, s3, e3;

    public SwapResult(int s1, int e1, int s2, int e2) {
        this.s1 = s1;
        this.s2 = s2;
        this.e1 = e1;
        this.e2 = e2;
        this.s3 = -1;
        this.e3 = -1;
        swap(2);
    }

    public SwapResult(int s1, int e1, int s2, int e2, int s3, int e3) {
        this.s1 = s1;
        this.s2 = s2;
        this.e1 = e1;
        this.e2 = e2;
        this.s3 = s3;
        this.e3 = e3;
        swap(3);
    }

    public void swap(int num) {
        if (num == 2) {
            int[] s = {s1, s2};
            int[] e = {e1, e2};
            Arrays.sort(s);
            Arrays.sort(e);
            s1 = s[0];
            s2 = s[1];
            e1 = e[0];
            e2 = e[1];
        } else if (num == 3) {
            int[] s = {s1, s2, s3};
            int[] e = {e1, e2, e3};
            Arrays.sort(s);
            Arrays.sort(e);
            s1 = s[0];
            s2 = s[1];
            s3 = s[2];
            e1 = e[0];
            e2 = e[1];
            e3 = e[2];
        }
    }
}
