package merge_k_sorted_lists;

import linked_list.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 暴力法，逐个合并
 * Time: O(kn)
 */
class Solution1{
}

/**
 * 堆排序，小顶堆
 * Time: O(nlogk)，k=链表的个数，n=所有链表节点的个数总和
 * Space: O(k), 堆最多要存放 k个节点
 */
class Solution2{
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode head : lists) if (head != null) pq.add(head);
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            tail.next = min;
            if (min.next != null) pq.add(min.next);
            tail = tail.next;
        }
        return dummy.next;
    }
}

/**
 * 分治法
 * Time: O(nlogk)
 * Space: O(logk)
 */
class Solution3 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return partitionMerge(lists, 0, lists.length - 1);
    }

    private ListNode partitionMerge(ListNode[] lists, int lo, int hi) {
        if (lo == hi)
            return lists[lo];
        int mid = (lo + hi) >>> 1;
        ListNode l1 = partitionMerge(lists, lo, mid);
        ListNode l2 = partitionMerge(lists, mid + 1, hi);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
}
