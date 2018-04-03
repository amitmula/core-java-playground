package algorithms.problems.painless;

import java.util.*;

public class StringEncoding {

    public static void main(String args[]) {
        System.out.println(collapseString("GGGGGGGrrrrrrrrrrt"));
    }

    static String collapseString(String input) {
        StringBuilder encodedString = new StringBuilder();
        if(!input.isEmpty()) {
            char[] charArray = input.toCharArray();
            int i = 0, count = 0;
            do {
                char current_char = input.charAt(i);
                count = 1;
                try{
                    int k = ++i;
                    while(input.charAt(k) == current_char) {
                        count++;
                        k = ++i;
                    }
                } catch (Exception ex) {

                }
                encodedString.append(count + String.valueOf(current_char));
            } while(i < charArray.length);
        }
        return encodedString.toString();
    }

}
