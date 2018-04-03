package core.exceptionHandling;

/**
 * Created by amit.k.mula on 29/3/17.
 */
public class ExceptionHandlingDemo {

    public int testReturn() {
        try {
            throw new Exception("Some exception occurred");
        } catch(Exception ex) {
            return 1;
        } finally {
            return 2;
        }
    }

    public static void main(String...args) {
        ExceptionHandlingDemo demo = new ExceptionHandlingDemo();
        int i = demo.testReturn();
        System.out.println("Returned value : " + i);
    }
}
