package algorithms.arrays;

/**
 * http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 * Search an element in a sorted and rotated array
 * An element in a sorted array can be found in O(log n) time via binary search.
 * But suppose we rotate an ascending order sorted array at some pivot unknown
 * to you beforehand. So for instance, 1 2 3 4 5 might become 3 4 5 1 2.
 * Devise a way to find an element in the rotated array in O(log n) time
 */
public class RotatedArraySearch {

    public static void main(String args[]) {
        int[] arr = {5,6,7,8,1,2,3,4};
        System.out.println("index of 3 in arr{5,6,7,8,1,2,3,4} is " + pivotedBinarySearch(arr, 3));

    }

    private static int pivotedBinarySearch(int[] arr, int key) {
        int pivot = findPivot(arr, 0, arr.length-1);
        if(pivot == -1) return binarySearch(arr, 0, arr.length-1, key);
        if(arr[pivot] == key) return pivot;
        if(arr[0] < key) return binarySearch(arr, 0,pivot+1, key);
        return binarySearch(arr, pivot+1, arr.length-1, key);
    }

    private static int findPivot(int[] arr, int low, int high) {
        if(low > high) return -1;
        if(low==high) return high;
        int mid = (low + high)/2;
        if(mid < high && arr[mid] > arr[mid+1])
            return mid;
        if(mid > low && arr[mid] < arr[mid-1])
            return (mid-1);
        if(arr[low] >= arr[mid]) return findPivot(arr, low, mid -1);
        return findPivot(arr, mid+1, high);
    }

    static int binarySearch(int arr[], int low, int high, int key) {
        if(high < low) return -1;
        if(high == low) return high;
        int mid = (low+high)/2;
        if(arr[mid] == key) return mid;
        if(key < arr[mid]) return binarySearch(arr, low, mid-1, key);
        return binarySearch(arr, mid+1, high, key);
    }


}
