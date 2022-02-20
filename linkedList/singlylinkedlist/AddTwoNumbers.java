package questions.leetcode.linkedList.singlylinkedlist;

public class AddTwoNumbers {
    //Input: l1 = [2,4,3], l2 = [5,6,4]
    //Output: [7,0,8]
    //Explanation: 342 + 465 = 807.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
       ListNode dummyList = new ListNode(0);
       ListNode resultList = dummyList;
       int carryNumber = 0;
       while(null!=l1 || null!=l2){
           int l1Value = (l1!=null)? l1.val : 0;
           int l2Value = (l2!=null)? l2.val : 0;
           int currentSum = l1Value + l2Value +carryNumber;
           carryNumber = currentSum/10;
           int lastDigit = currentSum %10;

           ListNode listNode = new ListNode(lastDigit);
           resultList.next = listNode;

           if(null!=l1) {
               l1= l1.next;
           }
           if(null!=l2) {
               l2= l2.next;
           }
           resultList = resultList.next;
       }
       if(carryNumber>0){
           ListNode listNode = new ListNode(carryNumber);
           resultList.next = listNode;
       }
       return dummyList.next;
    }


    public static void main(String[] args) {

    }
}
