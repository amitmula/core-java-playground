package algorithms.problems;

import java.io.BufferedReader;
import java.util.*;

public class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        */

        //Scanner
        /*Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        int rem = 1;
        int count = 0;
        while(rem > 0){
            rem  = (rem*10+1)%N; count++;
        }
        int num = 1;
        while(count > 0) {
            num  = num*10+1;
            count--;
        }
        System.out.println(num);*/

        /*Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        StringTokenizer st = new StringTokenizer(str, ",");
        int size = st.countTokens();

        int[] numbers = new int[size];

        int i =0;
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();

        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken().trim());
            if(countMap.containsKey(num)) {
                countMap.put(num, (Integer)countMap.get(num) + 1);
            } else
                countMap.put(num, 1);
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = countMap.entrySet().iterator();
        int max = 0, count = Integer.MIN_VALUE;
        while(iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if(count < next.getValue()) {
                count = next.getValue();
                max = next.getKey();
            }
        }
        System.out.println(max + ": " + count);*/

        /*String a = "Amit";
        String b = "Mula";
        String c = "AmitMula";
        String d = a.concat(b);
        String e = a+b;

        System.out.println(c==d);
        System.out.println(c==e);*/

        /*ArrayList<Integer> num_list = new ArrayList<Integer>();
        num_list.add(0, 10);
        num_list.add(0, 20);
        num_list.add(0, 30);
        System.out.println(num_list);*/

        /*
        //long instead of int to store large range of numbers
        Scanner scnr = new Scanner(System.in);
        int N = scnr.nextInt();
        scnr.nextLine();
        String input = scnr.nextLine();
        StringTokenizer tokenizer = new StringTokenizer(input, " ", false);
        long result = 1;
        while(N-- > 0) {
            int num = Integer.parseInt(tokenizer.nextToken());
            result = (long) ((result * num) % (Math.pow(10, 9) + 7));
        }
        System.out.println(result);*/

        /*int[] nums = {1,2,9,8,1,4,9,9,9};
        int k = 4;
        String maximumNum = findMaximumNum(nums, k, max);

        System.out.println(maximumNum);*/

        /*
        Find missing number from sorted array binary search way

        int[] nums = {1,2,3,4,6,7,8,9,10};

        System.out.println(findMissing(nums, 1, 10));*/

        int N = 77777777;
        long t;

        {
            StringBuffer sb = new StringBuffer();
            t = System.currentTimeMillis();
            for (int i = N; i-- > 0; ) {
                sb.append("");
            }
            System.out.println(System.currentTimeMillis() - t);
        }

        {
            StringBuilder sb = new StringBuilder();
            t = System.currentTimeMillis();
            for (int i = N; i-- > 0; ) {
                sb.append("");
            }
            System.out.println(System.currentTimeMillis() - t);
        }
    }

    private static int findMissing(int[] nums, int start, int end) {

        while(true) {
            int half = end/2;
            if(nums[half - 1] > half) {
                findMissing(nums, start, half);
            } else if (nums[half - 1] < half) {
                findMissing(nums, half+1, end);
            } else return half;
        }

    }

    /*private static int[] findMaximumNum(int[] nums, int k, String max) {
        if(k == 0)
            return nums;

        int n = str.length();
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if (str.charAt(i) < str[j])
                {
                    // swap str[i] with str[j]
                    swap(str[i], str[j]);

                    // If current num is more than maximum so far
                    if (str.compare(max) > 0)
                        max = str;

                    // recurse of the other k - 1 swaps
                    findMaximumNum(str, k - 1, max);

                    // backtrack
                    swap(str[i], str[j]);
                }
            }
        }
    }*/
}
