/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
*/
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = null, curr = null, curr1 = l1, curr2 = l2;
        
        while(curr1!=null && curr2!=null){
        	ListNode temp = null;
        	if(curr1.val<=curr2.val){
        		temp.val = curr1.val;
        		curr1 = curr1.next;
        	}
        	else{
        		temp.val = curr2.val;
        		curr2 = curr2.next;
        	}
        	if(newHead==null){
        		newHead = temp;
        		curr = newHead;
        	}
        	else{
        		curr.next = temp;
        	}
        }
        return newHead;
    }
}
