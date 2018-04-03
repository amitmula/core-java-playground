package algorithms;

import java.util.Scanner;

public class NSubArray {

    public static void main(String args[] ) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();    
        String numbers = scanner.nextLine();
        String[] tokens = numbers.split(" ");
        int[] nTokens = new int[n];
        for(int i=0; i<n; i++) {
            nTokens[i] = Integer.parseInt(tokens[i]);
        }
        Integer sum = 0;
        Integer prevSum = null;
        int max = Integer.MIN_VALUE;
        int count = 0;

        for(int i=0; i< nTokens.length; i++) {
            sum += nTokens[i];
            if(prevSum == null) {
                prevSum = sum;
                count++;
                continue;
            } else {
                if(sum.equals(prevSum)) {
                    if(max < count) max = count;
                    sum = 0;
                    count = 0;
                    prevSum = null;
                } else {
                    prevSum = sum;
                    count++;
                }
            }
        }
        System.out.println(max);
    }
}
