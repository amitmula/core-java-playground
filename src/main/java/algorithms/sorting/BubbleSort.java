package algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

    private void bubbleSort(int[] arr) {

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String...args) {
        int[] arr = {5,2,4,1,3};
        System.out.println("Unsorted Array : " + Arrays.toString(arr));

        BubbleSort sorter = new BubbleSort();
        sorter.bubbleSort(arr); //mutability @ rescue

        System.out.println("Sorted Array : " + Arrays.toString(arr));
    }

}
