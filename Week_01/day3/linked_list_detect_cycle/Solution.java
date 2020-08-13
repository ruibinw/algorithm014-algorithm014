package linked_list_detect_cycle;

import linked_list.ListNode;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/linked-list-cycle-ii

/**
 * 哈希表记录
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution1 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head)) return head;
            visited.add(head);
            head = head.next;
        }
        return null;
    }
}

/**
 * 快和慢指针
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head.next, fast = head.next.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
