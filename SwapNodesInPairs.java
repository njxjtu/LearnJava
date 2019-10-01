/*
Given a linked list, swap every two adjacent nodes and return its head. 
You may not modify the values in the list's nodes, only nodes itself may be changed.
Example:
Given 1->2->3->4, you should return the list as 2->1->4->3.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
    	ListNode ln = null, curr1=head, curr2 = null, curr3 = null;
 // Empty List
    	if(head == null){
    		return ln;
    	}
// One item
    	if(head != null && head.next == null){
    		return head;
    	}
// Two items
    	if(head != null && head.next != null && head.next.next == null){
    		ln = head.next;
    		ln.next = head;
    		head.next = null;
    		return ln;
    	}
// Three items
    	if(head != null && head.next != null && head.next.next != null && head.next.next.next == null){
    		System.out.println("3 items");
    		ListNode temp = head.next;
    		ln = temp;
    		ln.next = head;
    		ln.next.next = head.next.next;
    		return ln;
    	}
// More than three items
    	if(head != null && head.next != null && head.next.next != null && head.next.next.next != null){
    		ln = head.next;
    		ln.next = head;
    	//	ln.next.next = swapPairs(head.next.next);
    		return ln;
    	}
    	return ln;
    }

    public static void main(String[] args){
    	SwapNodesInPairs obj = new SwapNodesInPairs();
    	ListNode n0 = new ListNode(0), n1 = new ListNode(1), n2=new ListNode(2), curr = n0; //, n3=new ListNode(3) ;
    	n0.next = n1; n1.next = n2; // n2.next = n3; 
    	
    	while(curr !=null){
    		System.out.println(curr.val+" -> ");
    		curr = curr.next;
    	}
    	
    	curr = obj.swapPairs(n0);
    	while(curr !=null){
    		System.out.println(curr.val+" -> ");
    		curr = curr.next;
    	}
    }
}
