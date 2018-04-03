package algorithms.problems.painless;


public class AllOnes {

    public static void main(String...args) {
        int n = 13;
        int rem = 1;
        int count = 0;
        while(rem > 0){
            rem  = (rem*10+1)%n; count++;
        }
        int num = 1;
        while(count > 0) {
            num  = num*10+1;
            count--;
        }
        System.out.println(num);
    }

}
