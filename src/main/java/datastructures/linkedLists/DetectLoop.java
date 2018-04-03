package datastructures.linkedLists;

/**
 * Created by amit.k.mula on 22/3/17.
 */

// Node is defined as
class Node {
    int data;
    Node next;
    boolean visited;
    Node(int d) {data = d; next = null;}

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return this.visited;
    }
}

public class DetectLoop {
    int detectLoopByCheckVisited(Node head) {
        Node node;
        for(node=head; node.next != null; node = node.getNext()) {
            node.setVisited(true);
            if(node.getNext().isVisited())
                return 1;
        }
        return 0;
    }

    int detectLoopUsing2Pointers(Node head) {       //Floyd’s Cycle-Finding Algorithm
        Node slowP = head, fastP = head;
        while(slowP != null && fastP != null && fastP.getNext() != null) {
            slowP = slowP.getNext();
            fastP = fastP.getNext().getNext();
            if (slowP == fastP) return 1;
        }
        return 0;
    }

    public static void main(String args[]) {
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);
        Node node5 = new Node(50);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        DetectLoop loop = new DetectLoop();
        int i = loop.detectLoopByCheckVisited(node1);
        System.out.println("detectLoopByVisitedCheck output : " + i);
        i = loop.detectLoopUsing2Pointers(node1);
        System.out.println("detectLoopUsing2Pointers output : " + i);
    }
}
