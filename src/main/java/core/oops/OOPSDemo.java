package core.oops;

abstract class MyAbstractClass {

    public MyAbstractClass() {
        System.out.println("Executing abstract class constructor");
    }

    public static void print(String val) {
        System.out.println("static print() invoked from MyAbstarctClass with " + val);
    }

    /*public static void myMethod(double d) {
        MyAbstractClass.print("double");
    }*/

    public static void myMethod(long l) {
        MyAbstractClass.print("long");
    }

    public void myMethod(double i) {
        MyAbstractClass.print("int");
    }
}

class MyConcreetClass extends MyAbstractClass {

    public MyConcreetClass() {
        System.out.println("Executing concrete class constructor");
    }
}


public class OOPSDemo {
    public static void main(String args[]) {
        MyAbstractClass obj = new MyConcreetClass();
        obj.myMethod(new Integer(12));
    }
}
