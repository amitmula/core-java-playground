package datastructures.graphs.trees;

public class BSTChecker {
    public static void main(String args[]) {
        BSTChecker demo = new BSTChecker();

        // To keep tract of previous node in Inorder Traversal
        Node prev = null;
        Node root = new Node(10);

        root.left = new Node(5);
        root.left.left = new Node(2);
        root.left.right = new Node(7);

        root.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right = new Node(16);

        System.out.println(demo.isBST(root, prev));
    }

    public boolean isBST(Node node, Node prev) {
        if(node != null) {
            if(!isBST(node.left, prev))
                return false;

            if(prev != null && node.data < prev.data)
                return false;
            prev = node;
            return(isBST(node.right, prev));
        }
        return true;
    }
}
