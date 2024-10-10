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
    
    public static ListNode findHalf(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    public static ListNode rev(ListNode head)
    {
         ListNode prev = null;
         ListNode curr = head;
         
        while (curr != null)
         {
             ListNode next = curr.next;
             curr.next = prev;
             prev = curr;
             curr = next;
         }
         return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        
        
         if(head == null || head.next == null) 
         {
            return true;
        }
        
       
        
        ListNode half = findHalf(head);
        ListNode lastHead = rev(half.next);
        ListNode firstHead = head;
        
        while(lastHead!= null)
        {
            
            if(lastHead.val != firstHead.val) return false;
            firstHead = firstHead.next;
            lastHead = lastHead.next;    
        }
        
        return true;
    }
}