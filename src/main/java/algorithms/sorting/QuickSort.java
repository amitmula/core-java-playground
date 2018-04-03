package algorithms.sorting;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            sort(arr, low, pivot-1);
            sort(arr, pivot+1, high);
        }
    }

    private int partition(int arr[], int low, int high) {
        /*int pivot = arr[high];
        int i = low-1;
        for(int j=low; j<high; j++) {
            if(arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;*/

        int pivot, i, j;
        i = low;
        j = high;
        pivot = arr[i];
        while(true) {
            while(arr[i] < pivot && arr[i] != pivot) i++;
            while(arr[j] > pivot && arr[j] != pivot) j--;
            if(i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else return j;
        }
    }

    public static void main(String args[]) {
        int[] arr = {4,1,3,2,5,6};
        System.out.println("Unsorted Array : " + Arrays.toString(arr));
        QuickSort sorter = new QuickSort();
        sorter.sort(arr, 0, arr.length-1);
        System.out.println("Sorted Array : " + Arrays.toString(arr));
    }
}
