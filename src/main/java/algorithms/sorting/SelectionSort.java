package algorithms.sorting;


import java.util.Arrays;

public class SelectionSort {
    public int[] slectionSort(int[] arr) {
        if(arr == null || arr.length==0)
            return null;
        int min;
        for(int i=0; i<arr.length-1; i++) {
            min = i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void main(String args[]) {
        int[] arr = {1,4,5,2,8,3};
        System.out.println("Unsorted array : " + Arrays.toString(arr));
        SelectionSort sorter = new SelectionSort();
        sorter.slectionSort(arr);
        System.out.println("Sorted array : " + Arrays.toString(arr));
    }
}
