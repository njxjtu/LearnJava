package LearnJava;
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1=l1, c2=l2;
        ArrayList<ListNode> cc = new ArrayList<ListNode>();
        int i=0;
        while(c1!=null&&c2!=null){
            cc.add(addNodes(c1,c2));
            if(c1==l1 && c2==l2){ch = cc;}
            c1 = c1.next; c2 = c2.next; cc = cc.next;
        }
        return cc.get(0);
    }
    public ListNode addNodes(ListNode input1, ListNode input2, ListNode input3){

        if(input1 !=null && input2 != null){
            if(input1.val+input2.val+input3.val>9){
                input3.val = (input3.val + input1.val + input2.val)%10;
                input3.next = new ListNode(1);
            }
            else{
                input3.val = input3.val + input1.val + input2.val;
            }
        }
        if(input1 != null && input2 ==null){
            if(input1.val+input3.val>9){
                input3.val = (input3.val + input1.val )%10;
                input3.next = new ListNode(1);
            }
            else{
                input3.val = input3.val + input1.val ;
            }
        }
        if(input1 == null && input2 !=null){
            if(input2.val+input3.val>9){
                input3.val = (input3.val + input2.val )%10;
                input3.next = new ListNode(1);
            }
            else{
                input3.val = input3.val + input2.val ;
            }
        }
        return input3;
    }
}
