package algorithms.arrays;

/*
Find the two repeating elements in a given array
You are given an array of n+2 elements. All elements of the array are in range 1 to n. And all elements occur once except two numbers which occur twice. Find the two repeating numbers.

For example, array = {4, 2, 4, 5, 2, 3, 1} and n = 5

The above array has n + 2 = 7 elements with all elements occurring once except 2 and 4 which occur twice. So the output should be 4 2.

http://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
*/

public class TwoRepeatingNumbers {
    public static void main(String args[]) {

        int[] arr = {1,2,3,4,5,3,4,6,7,8};
        int xor = 0;
        for(int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }

        for(int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
    }
}
