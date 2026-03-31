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
          if (head == null) return null;
          int listLength = 0;
          ListNode curr = head;
          while(curr != null){
             listLength++;
             curr = curr.next;
          }
        //    if(n <= 0 || n > listLength ){
        //     return head;
        //    }
           if(n == listLength){
            return head.next;
           }
          curr = head;

          for(int i = 1; i < listLength - n; i++){
             curr = curr.next;
          }
          curr.next = curr.next.next;
          return head;
    }
}
