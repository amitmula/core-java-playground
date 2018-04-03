package collections.list.concurrent;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

    private List<Integer> numbers;

    public CopyOnWriteArrayListDemo() {
        this.numbers = new CopyOnWriteArrayList<Integer>();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static void main(String...args) {
        CopyOnWriteArrayListDemo demo = new CopyOnWriteArrayListDemo();
        List<Integer> numbers = demo.getNumbers();
        numbers.add(15);
        numbers.add(25);
        numbers.add(145);
        numbers.add(615);
        numbers.add(175);
        numbers.add(185);
        System.out.println("UnmodifiedList : " + numbers);
        Iterator<Integer> iterator = numbers.iterator();
        while(iterator.hasNext()) {
            Integer next = iterator.next();
            if(next.equals(615)) {
                numbers.remove(numbers.indexOf(615));
            }
        }
        System.out.println("modifiedList : " + numbers);
    }
}
