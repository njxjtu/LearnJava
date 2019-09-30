import java.util.Arrays;

/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

Input:
[
   ,
  1
]
Output: 1
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
    	ListNode newHead = null,curr = null, curr1 , curr2;;
        if(lists.length==0){
        	return newHead;
        }
        else if(lists.length==1){
        	return lists[0];
        }
        else if(lists.length >= 2){
        	System.out.println("In  >= 2");
        	curr1 = lists[0];
        	System.out.println("lists.length "+lists.length);
        	curr2 = mergeKLists(Arrays.copyOfRange(lists, 1, lists.length));
        	
        	if(curr1==null && curr2 !=null){
        		return curr2;
        	}
        	else if(curr1 != null && curr2 == null){
        		return curr1;
        	}
        	else if(curr1==null && curr1 == null){
        		return newHead;
        	}
        	//System.out.println("In  >= 2  curr2: "+curr2.val);
        	while(curr1!=null && curr2!=null){

            	if(curr1.val<=curr2.val){
            		
            		if(newHead == null){
                		newHead = curr1;
                		curr = newHead;
                	}
            		else{
            			curr.next = curr1;
            			curr = curr.next;
            		}
            		curr1 = curr1.next;
            	}
            	else{
            		
            		if(newHead == null){
                		newHead = curr2;
                		curr = newHead;
                	}
            		else{
            			curr.next = curr2;
            			curr = curr.next;
            		}
            		curr2 = curr2.next;
            	}
            	
            }
            
        	if(curr1 !=null){
        		curr.next = curr1;
        	}
           
            if(curr2 != null){
            	curr.next = curr2;
            }
        }
        return newHead;
    }
    
    public static void main(String[] args){
    	MergeKSortedLists obj = new MergeKSortedLists();
    	
/*    	ListNode n11 = new ListNode(1);
    	ListNode n12 = new ListNode(4);
    	ListNode n13 = new ListNode(5);
    	
    	ListNode n21 = new ListNode(1);
    	ListNode n22 = new ListNode(3);
    	ListNode n23 = new ListNode(4);
    	
    	ListNode n31 = new ListNode(2);
    	ListNode n32 = new ListNode(6);
    	
    	n11.next = n12; n12.next=n13;
    	n21.next = n22; n22.next=n23;
    	n31.next = n32;*/
    	
    	ListNode n11 = new ListNode(1);
    	
    	ListNode n21 = null;
    	
    	ListNode n31 = new ListNode(2);
    	ListNode n32 = new ListNode(6);
    	ListNode n33 = new ListNode(6);

    	n31.next = n32;n32.next = n33;

    	
/*    	int[] arr = {0,1,2,3,4};
    	arr = Arrays.copyOfRange(arr, 1, 2);
    	for(int i : arr){
    		System.out.println(i+", ");
    	}*/
    	ListNode[] ln = {n11, n21, n31};
    	ListNode rn = obj.mergeKLists(ln);
    	
    	while(rn != null){
    		System.out.println(rn.val+" -> ");
    		rn = rn.next;
    	}
    }
}
