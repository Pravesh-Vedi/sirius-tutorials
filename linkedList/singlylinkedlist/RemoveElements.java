package questions.leetcode.linkedList.singlylinkedlist;

public class RemoveElements {
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(4);
        node.next.next.next = new ListNode(5);
        node.next.next.next.next = new ListNode(7);
        node.next.next.next.next.next = new ListNode(4);
        ListNode listNode = removeElements(node,4);

        while(listNode!=null){
            System.out.print(+listNode.val + " ");
            listNode=listNode.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        while(head!=null && head.val == val){
            head=head.next;
        }
        ListNode dummyHead = head;
        while(dummyHead!=null && dummyHead.next!=null){
            if(dummyHead.next.val==val){
                dummyHead.next = dummyHead.next.next;
            }else{
                dummyHead = dummyHead.next;
            }
        }
        return head;
    }
}
