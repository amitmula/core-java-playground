package algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int arr[], int low, int high) {
        int mid;
        if(low < high) {
            mid = low + (high-low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int[] aux = new int[arr.length];
        int i, j, k=0;
        i = low;
        j = mid+1;
        while(i <= mid && j <= high) {
            if(arr[i] < arr[j]) {
                aux[k++] = arr[i++];
            } else aux[k++] = arr[j++];
        }

        while(i <= mid)
            aux[k++] = arr[i++];

        while(j <= high)
            aux[k++] = arr[j++];

        for(i=high; i >= low; i--)
            arr[i] = aux[--k];        // copying back the sorted list to a[]
    }

    public static void main(String...args) {
        int[] arr = {5,2,4,1,3};
        System.out.println("Unsorted Array : " + Arrays.toString(arr));

        MergeSort sorter = new MergeSort();
        sorter.mergeSort(arr, 0 , arr.length-1);

        System.out.println("Sorted Array : " + Arrays.toString(arr));
    }
}
