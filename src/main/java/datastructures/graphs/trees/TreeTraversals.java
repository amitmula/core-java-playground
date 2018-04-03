package datastructures.graphs.trees;

import java.util.LinkedList;
import java.util.Queue;

/*
Java program for different tree traversals

Depth First traversals  - Inorder, Preorder and Postorder
Breadth First traversal
*/
public class TreeTraversals {

    public void inOrderPrint(Node node) {
        if(null == node)
            return;
        inOrderPrint(node.left);
        System.out.print(" " + node.data);
        inOrderPrint(node.right);
    }

    public void preOrderPrint(Node node) {
        if(null == node)
            return;
        System.out.print(" " + node.data);
        preOrderPrint(node.left);
        preOrderPrint(node.right);
    }

    public void postOrderPrint(Node node) {
        if(null == node)
            return;
        postOrderPrint(node.left);
        postOrderPrint(node.right);
        System.out.print(" " + node.data);
    }

    public void breadthFirstTraversalPrint(Node node) {
        Queue<Node> tQueue = new LinkedList<Node>();

        tQueue.add(node);

        while(!tQueue.isEmpty()) {
            Node current = tQueue.poll();
            System.out.print(" " + current.data);

            if(null != current.left)
                tQueue.add(current.left);

            if(null != current.right)
                tQueue.add(current.right);

        }
    }

    public static void main(String args[]) {
        TreeTraversals demo = new TreeTraversals();
        Node root = new Node(10);

        root.left = new Node(5);
        root.left.left = new Node(2);
        root.left.right = new Node(7);

        root.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right = new Node(16);
        System.out.print("\ninOrder traversal -> ");
        demo.inOrderPrint(root);
        System.out.print("\npreOrder traversal -> ");
        demo.preOrderPrint(root);
        System.out.print("\npostOrder traversal -> ");
        demo.postOrderPrint(root);
        System.out.print("\nlevelOrder traversal -> ");
        demo.breadthFirstTraversalPrint(root);
    }

}
