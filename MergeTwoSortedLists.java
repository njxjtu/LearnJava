/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
*/
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = null, curr = null, curr1 = l1, curr2 = l2;
        if(l1==null){return l2;}
        if(l2==null){return l1;}
        
        while(curr1!=null && curr2!=null){
        	ListNode temp = null;
        	if(curr1.val<=curr2.val){
        		temp = curr1;
        		curr1 = curr1.next;
        	}
        	else{
        		temp = curr2;
        		curr2 = curr2.next;
        	}
        	System.out.println("temp: "+temp.val);
        	if(curr == null){
        		curr = temp;
        	}
        	else{
        		curr.next = temp;
        		curr = curr.next;
        	}
        	if(newHead == null){
        		newHead = curr;
        	}
        }
        
        while(curr1!=null){
        	ListNode temp = null;
        	System.out.println("curr1!=null");
        	temp = curr1;
        	curr.next = temp;
        	curr = curr.next;
        	curr1 = curr1.next;
        }
        while(curr2!=null){
        	ListNode temp = null;
        	System.out.println("curr2!=null");
        	temp = curr2;
        	curr.next = temp;
        	curr = curr.next;
        	curr2 = curr2.next;
        }
        
        return newHead;
    }
}
