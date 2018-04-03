package algorithms.arrays;

/**
 Find maximum (or minimum) sum of a subarray of size k
 Given an array of integers and a number k, find maximum sum of a subarray of size k.

 Example:
 Input  : arr[] = {100, 200, 300, 400}
 k = 2
 Output : 700
 */
public class MaxSumOfSubArray {

    public int maxSum(int[] arr, int k) {

        if(k > arr.length) return -1;

        int res = 0;

        for(int i=0; i<k; i++) {
            res += arr[i];
        }

        int current_sum = res;

        for(int i=k; i<arr.length; i++){
            current_sum += arr[i] - arr[i-k];
            if(res < current_sum) res = current_sum;
        }
        return res;
    }

    public static void main(String args[]) {
        int[] arr = {400, 200, 300, 100, 200};
        int k = 2;
        MaxSumOfSubArray driver = new MaxSumOfSubArray();
        System.out.println("Max sum of sub array of size k  : " + driver.maxSum(arr, k));
    }
}
