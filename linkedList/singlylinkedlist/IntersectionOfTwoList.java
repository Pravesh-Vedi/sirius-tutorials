package questions.leetcode.linkedList.singlylinkedlist;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoList {
    public static void main(String[] args) {

    }
    public ListNode getIntersectionNode_case01(ListNode headA, ListNode headB) {
        Set<ListNode>listNodeSet = new HashSet<>();
        while (headA!=null) {
            listNodeSet.add(headA);
            headA = headA.next;
        }
        while(headB!=null){
            if(listNodeSet.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode_case02(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        while(tempA!=tempB){
            tempA = null!=tempA ? tempA.next : headB;
            tempB = null!=tempB ? tempB.next : headA;
        }
        return tempA;
    }
}
