package main;

public class LC002AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode target = new ListNode(0);
        ListNode curr = target;
        int carry = 0;
        int v1, v2;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 == null) v1 = 0;
            else {
                v1 = l1.val;
                l1 = l1.next;
            }
            if (l2 == null) v2 = 0;
            else {
                v2 = l2.val;
                l2 = l2.next;
            }
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        return target.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
