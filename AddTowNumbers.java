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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode sum = dummy;
        int carry = 0;

        while(l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int currSum = val1 + val2 + carry; // 18
            int nodeVal = currSum % 10; // 8
            carry = currSum > 9 ? (currSum - nodeVal) / 10 : 0;
            
            sum.next = new ListNode(nodeVal);

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }

            sum = sum.next;
        }
        if(carry != 0) {
            sum.next = new ListNode(carry);
        }
   
        return dummy.next;
    }
}