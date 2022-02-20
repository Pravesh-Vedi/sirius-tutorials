package questions.leetcode.linkedList.singlylinkedlist;

public class LinkedList {
    Node head;

    class Node {
        int data;
        Node nextNode;

        Node(int value) {
            this.data = value;
            nextNode = null;
        }
    }

    public void push(int nodeValue) {
        Node new_node = new Node(nodeValue);
        new_node.nextNode = head;
        head = new_node;
    }


    public boolean detectLoop_01(Node listNode) {
        if(listNode==null){
            return false;
        }
        Node slowPointer = listNode;
        Node fastPointer = listNode.nextNode;
        while (slowPointer != null && fastPointer != null
                && fastPointer.nextNode != null) {
            slowPointer = slowPointer.nextNode;
            fastPointer = fastPointer.nextNode.nextNode;

            if (slowPointer == fastPointer) {
               return true;
            }
        }
        return false;
    }


    public boolean detectLoop() {
        Node slowPointer = head;
        Node fastPointer = head;
        boolean isLoopExist = false;
        while (slowPointer != null && fastPointer != null
                && fastPointer.nextNode != null) {
            slowPointer = slowPointer.nextNode;
            fastPointer = fastPointer.nextNode.nextNode;

            if (slowPointer == fastPointer) {
                isLoopExist = true;
                break;
            }
        }
        return isLoopExist;
    }


    public Node detectLoopNode_01(Node slowPointerNode) {
        Node slowPointer = head;
        Node fastPointer = head;
        while (slowPointer != null && fastPointer != null
                && fastPointer.nextNode != null) {
            slowPointer = slowPointer.nextNode;
            fastPointer = fastPointer.nextNode.nextNode;

            if (slowPointer == fastPointer) {
                break;
            }
        }
        return slowPointer;
    }


    public Node detectLoopNode(Node listNode) {
        Node slowPointer = head;
        Node fastPointer = head;
        while (slowPointer != null && fastPointer != null
                && fastPointer.nextNode != null) {
            slowPointer = slowPointer.nextNode;
            fastPointer = fastPointer.nextNode.nextNode;

            if (slowPointer == fastPointer) {
                break;
            }
        }
        return slowPointer;
    }

    public Node detectLoopNode_In_Two_List(LinkedList linkedList1,LinkedList linkedList2) {
        Node listPointer1 = linkedList1.head;
        Node listPointer2 = linkedList2.head;
        while(listPointer1!=listPointer2){
            if (listPointer1==null) {
                return linkedList2.head;
            }else{
                listPointer1= listPointer1.nextNode;
            }
            if (listPointer2==null) {
                return linkedList1.head;
            }else{
                listPointer2= listPointer2.nextNode;
            }
        }
        return listPointer1;
    }

    public Node detectLoopNode_In_Same_List(LinkedList linkedList) {
        Node listNode = linkedList.head;
        if(listNode==null || listNode.nextNode==null){
            return null;
        }

        Node intersectionNode = detectLoopNode(listNode);
        Node startNode = linkedList.head;
        if(intersectionNode==null){
            return null;
        }
        while(intersectionNode!=startNode){
            startNode = startNode.nextNode;
            intersectionNode = intersectionNode.nextNode;
        }
        return startNode;
    }
}
