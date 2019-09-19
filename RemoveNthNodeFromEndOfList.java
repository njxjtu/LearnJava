/*  ----Question----
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.
*/

/* Definition for singly-linked list. */

/*class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}*/


public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode newHead = head, currNode = head;
        int count=0;
        while(currNode!= null){
        	currNode = currNode.next;
        	count++;
        }
        currNode = head;
        ListNode[] temparr = new ListNode[count];
        for(int i=0; i<count; i++){
        	temparr[i] = currNode;
        	currNode = currNode.next;
        }
        if(n==0){
        	newHead = head;
        }
        else if(n==1 && count==1){
        	newHead = null;
        }
        else if(n==1 && count>1){
        	temparr[count-n-1].next = null;
        }
        else if(n==count){
        	newHead = temparr[1];
        }
        else if(n<count){
        	temparr[count-n-1].next = temparr[count-n+1];
        	temparr[count-n].next = null;
        }
        
        return newHead;
    }
    
    public static void main(String[] args){
    	RemoveNthNodeFromEndOfList obj = new RemoveNthNodeFromEndOfList();
    	ListNode lhead = new ListNode(1), lsecond = new ListNode(2), lthird = new ListNode(3), currLN = lhead;
    	lhead.next = lsecond; lsecond.next = lthird;
    	//
    	System.out.println("Original Linked List:");
    	while(currLN != null){
    		System.out.println(currLN.val);
    		currLN = currLN.next;
    	}
    	//
    	ListNode output = obj.removeNthFromEnd(lhead, 0);
    	System.out.println("Changed Linked List:");
    	currLN = output;
    	while(currLN != null){
    		System.out.println(currLN.val);
    		currLN = currLN.next;
    	}
    	
    }
}
