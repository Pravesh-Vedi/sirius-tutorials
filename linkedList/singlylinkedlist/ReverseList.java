package questions.leetcode.linkedList.singlylinkedlist;

public class ReverseList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(4);
        node.next.next.next = new ListNode(5);
        node.next.next.next.next = new ListNode(7);
        node.next.next.next.next.next = new ListNode(4);
        ListNode listNode = reverseList(node);

        while(listNode!=null){
            System.out.print(+listNode.val + " ");
            listNode=listNode.next;
        }
    }

    // null<--head->1->2->3->4->5->NULL
    //ListNode nextNode = head.next
    //ListNode previous = null;
    // NULL<-1<-2<-3<-4<-5
    public static ListNode reverseList(ListNode head) {
        ListNode previous = null;
        while(head!=null){
            ListNode nextNode = head.next;
            head.next = previous;
            previous = head;
            head = nextNode;
        }

        return previous;
    }
}
