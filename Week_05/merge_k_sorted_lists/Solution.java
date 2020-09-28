package merge_k_sorted_lists;

import linked_list.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 暴力法，逐个合并
 * Time: O(k*k*n), 假设 k 个链表，链表平均长度为 n
 * Space: O(1)
 */
class Solution1{
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        for (int i = 0; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}

/**
 * 堆排序，小顶堆
 * Time: O(nklogk)
 * Space: O(k), 堆最多要存放 k个节点
 */
class Solution2{
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode head : lists) if (head != null) heap.offer(head);

        ListNode preHead = new ListNode(0);
        ListNode p = preHead;
        while (!heap.isEmpty()) {
            ListNode minNode = heap.poll();
            p.next = minNode;
            p = p.next;

            if (minNode.next != null) heap.offer(minNode.next);
        }
        return preHead.next;
    }
}

/**
 * 分治法
 * Time: O(nklogk)
 * Space: O(logk)
 */
class Solution3 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return partitionMerge(lists, 0, lists.length - 1);
    }

    private ListNode partitionMerge(ListNode[] lists, int lo, int hi) {
        if (lo == hi) return lists[lo];

        int mid = (lo + hi) >>> 1;
        ListNode l1 = partitionMerge(lists, lo, mid);
        ListNode l2 = partitionMerge(lists, mid + 1, hi);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode p = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = (l1 != null) ? l1 : l2;
        return preHead.next;
    }
}
