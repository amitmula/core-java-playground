package algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {

    public void insertionSort(int[] arr) {
        int key; int j;
        for(int i=1; i<arr.length; i++) {
            key = arr[i];
            j=i-1;
            while(j >= 0 && key > arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void main(String args[]) {
        int[] arr = {5,2,4,1,3};
        System.out.println("Unsorted Array : " + Arrays.toString(arr));

        InsertionSort sorter = new InsertionSort();
        sorter.insertionSort(arr);

        System.out.println("Sorted Array : " + Arrays.toString(arr));
    }
}
