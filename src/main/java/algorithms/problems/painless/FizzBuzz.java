package algorithms.problems.painless;

import java.util.Scanner;

public class FizzBuzz {

    public static void main(String...args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        scanner.nextLine();
        if( T>0 && T<=10 ) {
            for(int i=0; i<T; i++) {
                int num = scanner.nextInt();
                if (num%5 == 0 && num%3 == 0) {
                    System.out.print("fizzbuzz");
                } else if (num%5 == 0) {
                    System.out.print("buzz");
                } else if (num%3 == 0) {
                    System.out.print("fizz");
                } else {
                    System.out.print(num);
                }
                System.out.print(" ");
            }
        }
    }

}
