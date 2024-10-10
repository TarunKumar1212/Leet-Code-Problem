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
        
        if(head.next == null) return null;
        
        int size = 0 ;
        ListNode temp = head;
        
        while( temp != null)
        {
            temp = temp.next;
            size++;
        }
        
        
        if(size == n) return head.next;
            
        int nth = size - n ;
        ListNode trav = head ;
        int  i = 1;
        
        while( i != nth)
        {
            
            trav = trav.next;
            i++;
        }
        
        trav.next = trav.next.next;
        
        return head;
    }
}