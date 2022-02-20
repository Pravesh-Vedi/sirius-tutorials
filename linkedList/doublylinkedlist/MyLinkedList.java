package questions.leetcode.linkedList.doublylinkedlist;

public class MyLinkedList {
    // Definition for doubly-linked list.
    static class DoublyListNode {
        int val;
        DoublyListNode next, prev;

        DoublyListNode(int x) {
            val = x;
        }
    }

    int size = 0;
    DoublyListNode head;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list.
     * If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size)
            return -1;
        DoublyListNode currentHead = head;
        for (int i = 0; i < index; i++) {
            currentHead = currentHead.next;
        }
        return currentHead.val;
    }

    /**
     * Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        DoublyListNode currentNode = new DoublyListNode(val);
        if (size != 0) {
            currentNode.next = head;
            head.prev = currentNode;
        }
        head = currentNode;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        DoublyListNode currentNode = new DoublyListNode(val);
        if (size == 0) {
            head = currentNode;
        } else {
            DoublyListNode currentHead = head;
            while (currentHead.next != null) {
                currentHead = currentHead.next;
                currentHead.next = currentNode;
                currentNode.prev = currentHead;
            }
            size++;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index == size) {
            addAtTail(val);
        } else if (index == 0) {
            addAtHead(val);
        } else {
            DoublyListNode currentHead = head;
            DoublyListNode currentNode = new DoublyListNode(val);
            for (int i = 0; i < index - 1; i++) {
                currentHead = currentHead.next;
                currentNode.next = currentHead.next;
                currentNode.prev = currentHead;
                currentNode.prev.next = currentNode;
                currentHead.next = currentNode;
                size++;
            }
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            DoublyListNode currentHead=head;
            for(int i=0;i<index-1;i++){
                currentHead=currentHead.next;
                if(currentHead.next.next==null){
                    currentHead.next=null;
                }else{
                    currentHead.next=currentHead.next.next;
                    currentHead.next.prev=currentHead;
                }
            }
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */