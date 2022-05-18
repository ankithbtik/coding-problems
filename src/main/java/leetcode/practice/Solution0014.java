package leetcode.practice;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Leetcode problem: https://leetcode.com/problems/add-two-numbers/
 */
public class Solution0014 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry=0;
        ListNode result = new ListNode(-1);
        ListNode head = result;
        while(l1 != null && l2 != null){
            int l1Val = l1.val;
            int l2Val = l2.val;

            int sum = l1Val + l2Val + carry;
            int val = sum%10;
            carry=sum/10;

            result.next = new ListNode(val);
            result = result.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int l1Val = l1.val;

            int sum = l1Val + carry;
            int val = sum%10;
            carry = sum/10;

            result.next = new ListNode(val);
            result = result.next;

            l1 = l1.next;
        }

        while(l2 != null){
            int l2Val = l2.val;

            int sum = l2Val + carry;
            int val = sum%10;
            carry = sum/10;

            result.next = new ListNode(val);
            result = result.next;

            l2 = l2.next;
        }

        if(carry != 0){
            result.next = new ListNode(carry);
        }

        return head.next;

    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
