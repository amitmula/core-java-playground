package core.immutibility;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Address {
    String flatNo;
    String street;
    String area;
    String city;
    String pincode;

    @Override
    public String toString() {
        return "Address{" +
                "flatNo='" + flatNo + '\'' +
                ", street='" + street + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }

    public Address(String flatNo, String street, String area, String city, String pincode) {
        this.flatNo = flatNo;
        this.street = street;
        this.area = area;
        this.city = city;
        this.pincode = pincode;
    }
}

final class Student {
    private final int id;
    private final String name;
    private final Address address;
    private final Map marks;
    //private static Person instance;

    public Student(int id, String name, Map marks, Address address) {
        this.id = id;
        this.name = name;
        this.address = new Address(address.flatNo, address.street, address.area, address.city, address.pincode);//address;
        this.marks = new HashMap();
        Iterator marksIterator = marks.entrySet().iterator();
        while(marksIterator.hasNext()) {
            Map.Entry<String, Integer> nextScore = (Map.Entry<String, Integer>) marksIterator.next();
            String subject  = nextScore.getKey();
            Integer score  = nextScore.getValue();
            this.marks.put(subject, score);
        }
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Map getMarks() {
        return (Map) ((HashMap<String, Integer>)this.marks).clone();
    }

    public Address getAddress() {
        return new Address(address.flatNo, address.street, address.area, address.city, address.pincode);
    }

    @Override
    public String toString() {
        return "Student {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", marks=" + marks +
                '}';
    }

    /*public static Person getInstance() {
        return instance;
    }

    public static Person getInstance(int id, String name, Map marks) {
        synchronized(instance) {
            if(instance==null) {
                synchronized(instance){
                    instance = new Person(id, name, marks);
                }
            }
        }
        return instance;
    }*/

}

public class FinalClassDemo {
    public static void main(String...args) {

        Address mutableAddress = new Address("270", "Major P Kumar Marg", "C4E Block, Janakpuri", "New Delhi", "110058");
        HashMap marks = new HashMap() {{
            put("English", 98);
            put("Science", 99);
            put("Maths", 100);
        }};

        Student student = new Student(10, "Amit", marks, mutableAddress);

        /*
        Map<String, Integer> marks = student.getMarks();
        Iterator<Map.Entry<String, Integer>> marksIterator = marks.entrySet().iterator();
        while(marksIterator.hasNext()) {
            marksIterator.remove();
        }
        */

        mutableAddress.flatNo = "323";

        System.out.println(student);
    }
}
