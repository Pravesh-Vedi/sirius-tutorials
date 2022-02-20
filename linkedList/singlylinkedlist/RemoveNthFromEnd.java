package questions.leetcode.linkedList.singlylinkedlist;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(4);
        node.next.next.next = new ListNode(5);
        node.next.next.next.next = new ListNode(7);
        node.next.next.next.next.next = new ListNode(4);
        ListNode listNode = removeNthFromEnd(node,3);

        while(listNode!=null){
            System.out.print(+listNode.val + " ");
            listNode=listNode.next;
        }

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode slowNode = dummyHead;
        ListNode fastNode = dummyHead;

        for(int i=0;i<n+1;i++){
            fastNode = fastNode.next;
        }

        while(fastNode!=null){
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        slowNode.next = slowNode.next.next;
        return dummyHead.next;
    }
}
