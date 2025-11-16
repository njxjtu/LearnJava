package LearnJava;
/*
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

import java.util.LinkedList;


class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
}

public class AddNumbers{
	
	LinkedList<Integer> addTwoLinkedList(LinkedList<Integer> l1, LinkedList<Integer> l2){
		LinkedList<Integer> result = new LinkedList<Integer>();
		int s1 = l1.size();
		int s2 = l2.size();
		int s3 = Math.max(s1, s2);
		int extra = 0;
		
		// Make the two lists same length
		for(int i = s1; i<s3; i++) {
			l1.add(0);
		}
		for(int i = s2; i<s3; i++) {
			l2.add(0);
		}
		
		if (s1 == 0) {
			return l2;
		}
		else if (s2 == 0) {
			return l1;
		}
		
		
		for (int i = 0; i< Math.max(s1, s2); i++) {
			
			int sum = l1.get(i) + l2.get(i) + extra;
			if(sum >= 10) {
				sum = sum%10;
				extra = 1;
			}
			else {
				extra = 0;
			}
			
			result.add(i, sum);
		}

		// clean up
		while (result.getLast().equals(0)) {
			result.removeLast();
		}
		
		return result;
	};
	
	public static void main(String[] args) {
		AddNumbers ads = new AddNumbers();
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		LinkedList<Integer> l3 = new LinkedList<Integer>();
		
		l1.add(2);
		l1.add(4);
		l1.add(3);
		
		l2.add(5);
		l2.add(6);
		l2.add(4);
		
		l3 = ads.addTwoLinkedList(l1, l2);
		
		for(int i = 0; i<l3.size(); i++) {
			System.out.println(l3.get(i));
		}
	}
}

	 
//class Solution {
//  
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode c1=l1, c2=l2;
//        ArrayList<ListNode> cc = new ArrayList<ListNode>();
//        int i=0;
//        while(c1!=null&&c2!=null){
//            cc.add(addNodes(c1,c2, null));
//            if(c1==l1 && c2==l2){ch = cc;}
//            c1 = c1.next; c2 = c2.next; cc = cc.next;
//        }
//        return cc.get(0);
//    }
//    public ListNode addNodes(ListNode input1, ListNode input2, ListNode input3){
//
//        if(input1 !=null && input2 != null){
//            if(input1.val+input2.val+input3.val>9){
//                input3.val = (input3.val + input1.val + input2.val)%10;
//                input3.next = new ListNode(1);
//            }
//            else{
//                input3.val = input3.val + input1.val + input2.val;
//            }
//        }
//        if(input1 != null && input2 ==null){
//            if(input1.val+input3.val>9){
//                input3.val = (input3.val + input1.val )%10;
//                input3.next = new ListNode(1);
//            }
//            else{
//                input3.val = input3.val + input1.val ;
//            }
//        }
//        if(input1 == null && input2 !=null){
//            if(input2.val+input3.val>9){
//                input3.val = (input3.val + input2.val )%10;
//                input3.next = new ListNode(1);
//            }
//            else{
//                input3.val = input3.val + input2.val ;
//            }
//        }
//        return input3;
//    }
//}
