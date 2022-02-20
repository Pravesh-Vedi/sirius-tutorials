package questions.leetcode.linkedList.singlylinkedlist;

public class DetectLoop {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.push(10);
        linkedList.push(20);
        linkedList.push(30);
        linkedList.push(40);
        linkedList.push(50);
        linkedList.push(60);
        linkedList.push(70);
        linkedList.push(80);

        linkedList.head.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode = linkedList.head;
        System.out.println("Loop Exist :: " +linkedList.detectLoop());
        System.out.println("Loop Exist In Same List :: " +linkedList.detectLoopNode_In_Same_List(linkedList).data);

        LinkedList linkedList1 = new LinkedList();
        linkedList1.push(1);
        linkedList1.push(9);
        linkedList1.push(1);
        linkedList1.push(2);
        linkedList1.push(4);

        LinkedList linkedList2 = new LinkedList();
        linkedList2.push(3);
        linkedList2.push(2);
        linkedList2.push(4);

        LinkedList linkedList3 = new LinkedList();
        System.out.println("Loop Node Value :: " +linkedList3.detectLoopNode_In_Two_List(linkedList1,linkedList2).data);
    }
}
