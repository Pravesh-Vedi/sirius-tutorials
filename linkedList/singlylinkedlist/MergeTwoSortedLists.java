package questions.leetcode.linkedList.singlylinkedlist;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(4);

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(node1,node);
        while(listNode!=null){
            System.out.print(+listNode.val + " ");
            listNode=listNode.next;
        }
    }

    //Input: list_01= [1,2,4], list_02 = [1,3,4]
    //Output: [1,1,2,3,4,4]
    public static ListNode mergeTwoLists(ListNode list_01, ListNode list_02) {
        ListNode dummyList = new ListNode(-1);
        ListNode head = dummyList;
        while(list_01!=null && list_02 !=null){
            if(list_01.val<list_02.val){
                dummyList.next = list_01;
                list_01 = list_01.next;
            }else{
                dummyList.next=list_02;
                list_02 = list_02.next;
            }
            dummyList= dummyList.next;
        }
        if(list_01!=null){
            dummyList.next = list_01;
        }else{
            dummyList.next = list_02;
        }
        return head.next;
    }
}
