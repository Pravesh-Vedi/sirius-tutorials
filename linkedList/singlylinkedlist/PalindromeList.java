package questions.leetcode.linkedList.singlylinkedlist;

public class PalindromeList {
    public static void main(String[] args) {

    }

    // Input: 1->2->2->1
    // Output: true

    // Input: 1->2
    // Output: false
    public static boolean isValidPalindrome(ListNode list_01) {
        ListNode slowPointer = list_01;
        ListNode fastPointer = list_01;
        ListNode mid = null;

        while(fastPointer!=null && fastPointer.next!=null){
            slowPointer= slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        if(fastPointer!=null){
            mid=slowPointer.next;
        }else{
            mid = slowPointer;
        }

        ListNode next  = null;
        ListNode previous = null;
        while(mid!=null){
            next = mid.next;
            mid.next = previous;
            previous = mid;
            mid = next;


        }
        while (previous!=null){
            if(previous.val!=list_01.val){
                return  false;
            }
            previous = previous.next;
            list_01 = list_01.next;
        }
        return true;
    }
}
