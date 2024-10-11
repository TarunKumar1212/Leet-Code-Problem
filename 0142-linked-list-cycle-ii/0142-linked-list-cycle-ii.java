/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
       
        if (head == null) return null;
        
        ListNode fast = head;
        ListNode slow = head;
        
        // Phase 1: Detect if a cycle exists
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if (fast == slow) {
                // If cycle is detected, find the cycle start
                return findCycleStart(slow, head);
            }
        }
        
        return null; // No cycle detected
    }
    
    // Helper method to find the start of the cycle
    public ListNode findCycleStart(ListNode slow, ListNode head) {
        ListNode pointer1 = head;
        ListNode pointer2 = slow;
        
        // Phase 2: Both pointers move one step at a time until they meet
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        
        return pointer1; // The start of the cycle
    }
}
