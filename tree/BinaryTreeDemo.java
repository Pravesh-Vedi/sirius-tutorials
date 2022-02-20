package questions.leetcode.tree;

public class BinaryTreeDemo {

    static class Node {
        int data;
        Node leftTree;
        Node rightTree;

        public Node(int data, Node leftTree, Node rightTree) {
            this.data = data;
            this.leftTree = leftTree;
            this.rightTree = rightTree;
        }

        public Node(int data) {
            this.data = data;
        }
    }

    static Node rootNode;
    public static void main(String[] args) {
        createTree();
        inOrderTraversal(rootNode);
        preOrderTraversal(rootNode);
        postOrderTraversal(rootNode);
    }

    private static void createTree() {
        add(3);
        add(4);
        add(5);
        add(6);
        add(7);
        add(8);
        add(9);
    }

    public static void add(int value) {
        rootNode = addRecursive(rootNode, value);
    }

    private static Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.data) {
            current.leftTree = addRecursive(current.leftTree, value);
        } else if (value > current.data) {
            current.rightTree = addRecursive(current.rightTree, value);
        } else {
            return current;
        }
        return current;
    }


    private static void postOrderTraversal(Node root) {//LRN
        if (root != null) {
            postOrderTraversal(root.leftTree);
            postOrderTraversal(root.rightTree);
            System.out.print(" " + root.data);
        }
    }

    private static void preOrderTraversal(Node root) {//NLR
        if (root != null) {
            System.out.print(" " + root.data);
            preOrderTraversal(root.leftTree);
            preOrderTraversal(root.rightTree);
        }
    }

    private static void inOrderTraversal(Node root) {//LNR
        if (root != null) {
            inOrderTraversal(root.leftTree);
            System.out.print(" " + root.data);
            inOrderTraversal(root.rightTree);
        }
    }
}
