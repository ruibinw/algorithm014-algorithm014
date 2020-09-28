class Solution1:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        prehead = ListNode()
        p = prehead
        while l1 and l2:
            if l1.val < l2.val:
                p.next, l1 = l1, l1.next
            else:
                p.next, l2 = l2, l2.next
            p = p.next
        p.next = l1 if l1 else l2
        return prehead.next


class Solution2:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 is None: return l2
        if l2 is None: return l1

        if l1.val < l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l2.next, l1)
            return l2