package algorithms.problems.respectable;

/**

 Task 1
 Java 0h 33m
 Task description
 Elliot the Hawk has a very important task − the breeding season has come. He needs to prepare a nest in which his mating partner Eleonora will lay eggs, then look after her until they switch responsibility for taking care of the eggs.

 There are N birds' nests standing in a line, one after another. Every two nests are positioned at distinct heights.

 Elliot needs to pick a nest in which Eleonora will lay her eggs. Then, each day, Elliot will hunt from one of the other nests. At the end of the day, he will bring the food to Eleonora and move to some other nest on the opposite side of their own nest. He can hunt from each nest at most once. Moreover, on each day he needs to hunt from a nest that is positioned higher than the previous nest, and higher than their own nest.

 Elliot can return to their own nest and switch roles with Eleonora at any time. In particular, he may simply prepare their nest, then refrain from hunting at all.

 For example, assume the nests are positioned at heights 4 6 2 1 5. Elliot can, for instance, prepare the nest at height 1, then hunt from the nest at height 4, on the next day hunt from the nest at height 5, and on the last day hunt from the nest at height 6:



 Note that in this situation, Elliot cannot hunt from the nest at height 6 just after hunting from the nest at height 4, because these two nests are on the same side of his own nest. Also, after hunting from the rightmost nest, he cannot hunt from the leftmost nest, as it is lower than the previous one. If Elliot chooses the nest at height 6 as their own nest, then he cannot hunt at all, because all other nests are placed lower.

 Elliot wonders how many possible ways there are for him to choose their nest and then hunt until he changes places with Eleonora. As the result may be very large, count the number of possibilities modulo 109 + 7 (1,000,000,007).
 Write a function:

 class Solution { public int solution(int[] H); }

 that, given a sequence of heights of nests, returns the remainder from the division by 1,000,000,007 of the number of possible ways for Elliot to choose the nest and hunt.

 For example, given:

 H = [ 13, 2, 5 ]
 the function should return 7. All the possible ways for Elliot to choose the nest and hunt are as follows, listed one per line. The first number in each line denotes the height of Elliot's own nest, and each consecutive number describes the height of a nest he will hunt from.

 13
 5 13
 5
 2 5 13
 2 5
 2 13
 2
 On the other hand, for the following array:

 H = [ 4, 6, 2, 1, 5 ]
 the function should return 23. One of the possible ways Elliot can act is depicted in the figure above.

 Assume that:

 N is an integer within the range [1..50,000];
 each element of array H is an integer within the range [1..1,000,000,000];
 the elements of H are all distinct.
 Complexity:

 expected worst-case time complexity is O(N*log(N));
 expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 Elements of input arrays can be modified.

 Copyright 2009–2017 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 Custom test casesformat: [13, 2, 5]	0/10
 Solution


 1
 2
 3
 4
 5
 6
 7
 8
 9
 10
 11
 12
 // you can also use imports, for example:
 // import java.util.*;
 // you can write to stdout for debugging purposes, e.g.
 // System.out.println("this is a debug message");
 class Solution {
 public int solution(int[] H) {
 // write your code in Java SE 8
 for(int i =0 ;)
 }
 }
 Java SE 8All changes saved.Keyboard shortcuts
 Help     Run     Submit this task  Quit
 Output console
 accessibility mode is disabled
 *
 *
 *
 * https://codility.com/c/run/certTQPSNX-DGCDV3YWQ9BM8U59#final-form
 *
 *
 */
public class NestHuntDemo {

    public static int countHunts(int[] arr) {
        for(int i=0; i< arr.length; i++) {
            int home = i; int k=i; int current =i;
            boolean turn = true;
            while(turn) {

            }
        }
        return 0;
    }

    public static void main(String args[]) {
        int arr[] = {4,6,2,1,5};

    }
}