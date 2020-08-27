package linked_list_reverse_print;

import linked_list.ListNode;

public class Solution {

    private int[] result;

    public int[] reversePrint(ListNode head) {
        reverse(head, 0);
        return result;
    }

    private void reverse(ListNode head, int count) {
        if (head == null) {
            result = new int[count];
            return;
        }
        reverse(head.next, count + 1);
        result[result.length - count - 1] = head.val;
    }
}
