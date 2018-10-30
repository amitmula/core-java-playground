package algorithms.problems.dailycodingproblems;

/*
*
* Given an array of integers, find the first missing positive integer in linear time and constant space.
* In other words, find the lowest positive integer that does not exist in the array. The array can contain
* duplicates and negative numbers as well.
*
* For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
* You can modify the input array in-place.
*
* */

public class Problem4 {

    public static int getFirstPositiveInteger(int[] arr) {
        int current_val, next_val; int size = arr.length;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] <= 0 || arr[i] > size) continue;
            current_val = arr[i];
            while(arr[current_val - 1] != current_val) {
                next_val = arr[current_val - 1];
                arr[current_val - 1] = current_val;
                current_val = next_val;
                if(current_val <= 0 || current_val > size) break;
            }
        }
        for(int i=0; i <size; i++) {
            if(arr[i] != i+1) return i+1;
        }
        return size + 1;
    }

    public static void main(String args[]) {
        int[] arr = {3, 4, -1, 1};
        System.out.println(getFirstPositiveInteger(arr));
        arr = new int[]{1, 2, 0};
        System.out.println(getFirstPositiveInteger(arr));
        arr = new int[]{2, 3, 7, 6, 8, -1, -10, 15};
        System.out.println(getFirstPositiveInteger(arr));
        arr = new int[]{2, 3, -7, 6, 8, 1, -10, 15};
        System.out.println(getFirstPositiveInteger(arr));
        arr = new int[] {1, 1, 0, -1, -2};
        System.out.println(getFirstPositiveInteger(arr));
    }
}
