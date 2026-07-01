/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       int listlength = 0;
       ListNode curr = head;
       if(head == null){
           return null;
       }
       while(curr != null){
         listlength++;
         curr = curr.next;
       }
       if(n == listlength){
          return head.next;
       }
       curr = head;
       for(int i = 1; i < listlength - n; i++){
          curr = curr.next;
       }
       curr.next = curr.next.next;
       return head;
    }
}
