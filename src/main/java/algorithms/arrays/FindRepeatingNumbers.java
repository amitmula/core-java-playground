package algorithms.arrays;

/*
Find duplicates in O(n) time and O(1) extra space
Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing any number of times. Find these repeating numbers in O(n) and using only constant memory space.

For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.

*/

import java.util.ArrayList;
import java.util.List;

public class FindRepeatingNumbers {


    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 1, 3, 6, 6};
        findRepeatingNumbers(arr);
    }

    private static void findRepeatingNumbers(int arr[]) {
        System.out.print("Repeating numbers :");
        List repeatingNums = new ArrayList();
        for(int i=0; i<arr.length; i++) {
            if(arr[Math.abs(arr[i])] >= 0)
                arr[Math.abs(arr[i])] *= -1;
            else
                System.out.print(" " + Math.abs(arr[i]));
        }
    }
}
