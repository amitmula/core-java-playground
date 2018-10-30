package algorithms.problems.dailycodingproblems;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/*
Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s),
which deserializes the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'
*/

public class Problem3 {

    static class Node {
        int val; Node left, right; List<Integer> inorderNotation, preorderNotation;
        int preIndex = 0;
        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.inorderNotation = new ArrayList<>();
            this.preorderNotation = new ArrayList<>();
        }
        private Node constructTree(Integer inArr[], Integer preArr[], int inStart, int inEnd) {
            Node tree = new Node(preArr[preIndex++], null, null);
            if(inStart == inEnd) return tree;
            int inArrIndx = findIndexInArr(inArr, tree.val);
            tree.left = constructTree(inArr, preArr, inStart, inArrIndx - 1);
            tree.right = constructTree(inArr, preArr, inArrIndx + 1, inEnd);
            return tree;
        }

        private int findIndexInArr(Integer[] arr, int val) {
            int index = -1;
            for(int i=0; i< arr.length; i++) {
                if(arr[i] == val) {
                    return i;
                }
            }
            return index;
        }

        private void genInOrderNotation(Node root) {
            if(root == null) return;
            genInOrderNotation(root.left);
            this.inorderNotation.add(root.val);
            genInOrderNotation(root.right);
        }

        private void genPreOrderNotation(Node root) {
            if(root == null) return;
            this.preorderNotation.add(root.val);
            genPreOrderNotation(root.left);
            genPreOrderNotation(root.right);
        }

        public Integer[] getInorderArray() {
            Integer[] inArr = new Integer[inorderNotation.size()];
            return inorderNotation.toArray(inArr);
        }

        public Integer[] getPreorderArray() {
            Integer[] preArr = new Integer[preorderNotation.size()];
            return preorderNotation.toArray(preArr);
        }
        
        public String serialize() {
            return Arrays.toString(getInorderArray()) + ":" + Arrays.toString(getPreorderArray());
        }

        public Node deserialize() {
            return constructTree(getInorderArray(), getPreorderArray(), 0, getInorderArray().length - 1);
        }
    }

    public static void main(String args[]) {
        Node root = new Node(50, null, null);
        root.left = new Node(20, new Node(10, null, null), new Node(30, null, null));
        root.right = new Node(60, new Node(55, null, null), new Node(70, null, null));
        root.genInOrderNotation(root);
        root.genPreOrderNotation(root);
        System.out.println("serialized ->" + root.serialize());
        Node deserializedTree = root.deserialize();
        deserializedTree.genInOrderNotation(root);
        deserializedTree.genPreOrderNotation(root);
        System.out.println("deserialized ->" + deserializedTree.serialize());
    }
}
