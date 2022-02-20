package questions.leetcode.linkedList.singlylinkedlist;

public class ListOperation {
    static Node head=null;
    static class Node {
        int data;
        Node nextNode;

        public Node(int data, Node nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }

        public Node(int data) {
            this.data = data;
        }
    }
    public static void main(String[] args) {
        addInBeginning(new Node(30),true);
        addInBeginning(new Node(40),true);
        addInBeginning(new Node(60),true);
        addInBeginning(new Node(70),true);

        Node tmp = head;
        int maxVal =0;
        while(tmp!=null){
            if(tmp.data>maxVal){
                maxVal=tmp.data;
            }
            tmp = tmp.nextNode;
        }
        System.out.println("Max Value is :: " +maxVal);

        while(head!=null){
            System.out.println("Data is :: " +head.data);
            head=head.nextNode;
        }

        /*deleteFromBeginning();
        deleteAtEnd();
        deleteAtPosition(2);*/


        addNode(new Node(10),false);
        addNode(new Node(40),false);
        addNode(new Node(60),false);
        addNode(new Node(70),false);
        deleteAtPosition(2);

        while(head!=null){
            System.out.println("Data is :: " +head.data);
            head=head.nextNode;
        }
    }

    private static void deleteAtPosition(int position) {
        Node fastPointer = head;
        Node slowPointer = null;
        for(int i=0;i<position-1;i++){
            slowPointer=fastPointer;
            fastPointer = fastPointer.nextNode;
        }
        assert slowPointer != null;
        slowPointer.nextNode=fastPointer.nextNode;
    }

    private static void deleteAtEnd() {
        Node tmpNode = head;
        Node previousToLastNode = null;
        while (tmpNode.nextNode!=null){
            previousToLastNode = tmpNode;
            tmpNode = tmpNode.nextNode;
        }
        assert previousToLastNode != null;
        previousToLastNode.nextNode=null;
    }

    private static void deleteFromBeginning() {
        Node tmpNode = head;
        if(tmpNode==null){
            System.out.println("List is empty");
        }else{
            tmpNode = tmpNode.nextNode;
            head=tmpNode;
        }
    }

    public static void addInBeginning(Node node, boolean beginning){
        if(beginning) {
            if (head != null) {
                node.nextNode = head;
            }
            head = node;
        }
    }
    public static void addNode(Node node, boolean beginning){
        if(!beginning) {
            if (head == null) {
                head = node;
            } else {
                Node tmpNode = head;
                while (tmpNode.nextNode != null) {
                    tmpNode = tmpNode.nextNode;
                }
                tmpNode.nextNode = node;
            }
        }
    }
}
