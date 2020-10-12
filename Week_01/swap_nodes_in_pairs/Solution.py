class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        node = head.next
        head.next = self.swapPairs(node.next)
        node.next = head
        return node
