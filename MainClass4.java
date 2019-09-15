import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class MainClass4 {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r) {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;

        /* create temp arrays */
        int[] left = new int[n1];
        int[] right = new int[n2];

        /* Copy data to temp arrays L[] and R[] */
        for (i = 0; i < n1; i++)
            left[i] = arr[l + i];
        for (j = 0; j < n2; j++)
            right[j] = arr[m + 1 + j];

        /* Merge the temp arrays back into arr[l..r]*/
        i = 0; // Initial index of first subarray
        j = 0; // Initial index of second subarray
        k = l; // Initial index of merged subarray
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

    /* Copy the remaining elements of L[], if there
       are any */
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

    /* Copy the remaining elements of R[], if there
       are any */
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] combined = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, combined, 0, nums1.length);
        System.arraycopy(nums2, 0, combined, nums1.length, nums2.length);
        merge(combined, 0, nums1.length-1,combined.length-1);
        if(combined.length % 2 == 0) {
            return ((double) (combined[combined.length / 2 - 1] + combined[combined.length / 2])) /2;
        } else {
            return combined[combined.length/2];
        }
    }

    public static void main(String[] args) {
        int[] values = new int[]{1, 3};
        int[] values2 = new int[]{2};
        System.out.println(new MainClass4().findMedianSortedArrays(values, values2));

        int[] values3 = new int[]{1, 2};
        int[] values4 = new int[]{3, 4};
        System.out.println(new MainClass4().findMedianSortedArrays(values3, values4));
    }
}
