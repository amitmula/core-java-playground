package datastructures.stack;

import java.util.ListIterator;
import java.util.Stack;

public class StackDemo {

    public static void main(String...args) {
        Stack<String> stack = new Stack();
        stack.push("ABC");
        stack.push("DEF");
        stack.push("GHI");
        stack.push("JKL");
        stack.push("MNO");
        stack.push("PQR");
        ListIterator<String> listIterator = stack.listIterator();
        int size = stack.size();
        int count = 0 ;
        while(listIterator.hasNext()) {
            if(count == size-1) {
                System.out.println(listIterator.previous().toString());
                break;
            }
            System.out.println(listIterator.next().toString());
            count++;
        }

    }
}
