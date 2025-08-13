package LearnJava;
/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
Example:
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5
Note:
Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
    	
    	ListNode curr = head , newhead = null;
    	int len = 0;
    	while(curr != null){
    		len++;
    		curr = curr.next;
    	}
// empty list or < k items
    	if(len ==0 || len<k){
    		return  head;
    	}
// >= k item
    	curr = head;
    	if(len >= k){
    		ListNode[] lnarr = new ListNode[k];
    		for(int i=0; i<k; i++){
    			lnarr[i] = curr;
    			curr = curr.next;
    		}
    		ListNode temphead = reverseKGroup(curr, k);
            curr = null;
    		for(int i=k-1; i>=0; i--){
    			if(curr==null){
    				curr = lnarr[i];
    				newhead = lnarr[i];
    				if(i-1>=0){
    					newhead.next = lnarr[i-1];
    				}
    				else if(i-1<0){
    					newhead.next = null;
    				}
    			}
    			else{
    				curr.next = lnarr[i];
    				curr = curr.next;
    			}
    		}
    		curr.next = temphead;
    		return newhead;
    	}
    	
    	return head;
    }
    
    public static void main(String[] args){
    	ReverseNodesInKGroup obj = new ReverseNodesInKGroup();
    	ListNode n11 = new ListNode(1);
    	ListNode n12 = new ListNode(4);
    	ListNode n13 = new ListNode(5);
    	ListNode n14 = new ListNode(8);
    	n11.next = n12; n12.next=n13; n13.next=n14;
    	ListNode rn = obj.reverseKGroup(n11, 2);
    	while(rn != null){
    		System.out.println(rn.val+" -> ");
    		rn = rn.next;
    	}
    }
}
