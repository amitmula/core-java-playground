package algorithms.problems.dailycodingproblems;

/*
* Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
* For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17
* Bonus: Can you do this in one pass?
*/

import java.util.HashSet;

public class Problem1 {


    private static boolean findIfKinArr(int[] arr, int k) {
        HashSet<Integer> elements = new HashSet<Integer>();
        for(int i : arr) {
            if(elements.contains(k - i)) return true;
            else {
                elements.add(i);
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int arr[] = {5,4,6,8,1};
        System.out.println(findIfKinArr(arr, 8));
    }

}
