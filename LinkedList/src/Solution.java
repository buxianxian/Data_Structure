public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            ListNode temp = head; //在leetcode中不是必须的
            head = head.next;
            temp.next = null; //非必须
        }

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode temp = prev.next; //非必须
                prev.next = temp.next;
                temp.next = null; //非必须
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
}
