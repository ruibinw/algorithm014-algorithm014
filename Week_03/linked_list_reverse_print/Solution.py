# 递归到尾后，再把值从尾添加到数组
class Solution1:
    # [] + [] 涉及到数据搬移，效率低
    # def reversePrint(self, head: ListNode) -> List[int]:
    #     return self.reversePrint(head.next) + [head.val] if head else []

    def reversePrint(self, head: ListNode) -> List[int]:
        # 递归到尾后，再把值从尾添加到数组
        def reverse(head):
            if head:
                reverse(head.next)
                res.append(head.val)

        res = []
        reverse(head)
        return res


# 循环
class Solution2:
    def reversePrint(self, head: ListNode) -> List[int]:
        res = []
        while head:
            res.append(head.val)
            head = head.next
        return res[::-1]
