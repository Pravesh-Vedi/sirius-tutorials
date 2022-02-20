package questions.leetcode.linkedList.doublylinkedlist;

public class DoublyLinkedListOperations {
    static Node head = null;
    static Node tail = null;

    static class Node {
        int data;
        Node nextNode;
        Node prevNode;

        public Node(int data, Node nextNode, Node prevNode) {
            this.data = data;
            this.nextNode = nextNode;
            this.prevNode = prevNode;
        }

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        addInBeginning(new Node(30), true);
        addInBeginning(new Node(40), true);
        addInBeginning(new Node(60), true);
        addInBeginning(new Node(70), true);

        while (head != null) {
            System.out.println("Data is :: " + head.data);
            head = head.nextNode;
        }

        addNode(new Node(10), false);
        addNode(new Node(40), false);
        addNode(new Node(60), false);
        addNode(new Node(70), false);

        Node tmp = head;
        while (head != null) {
            System.out.println("Data added at the end is :: " + head.data);
            head = head.nextNode;
        }
    }

    public static void addInBeginning(Node node, boolean beginning) {
        if (beginning) {
            if (head != null) {
                node.nextNode = head;
                head.prevNode = node;
            }
            head = node;
            tail = node;
        }
    }

    public static void addNode(Node node, boolean beginning) {
        if (!beginning) {
            if (head == null) {
                head = node;
            } else {
                tail.nextNode = node;
                node.prevNode = tail;
                tail = node;
            }

        }
    }
}
