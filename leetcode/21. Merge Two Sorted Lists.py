class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        l3_head = ListNode(-1)
        l3 = l3_head
        while l1 is not None and l2 is not None:
            if l1.val < l2.val:
                l3.next = ListNode(l1.val)
                l1 = l1.next
            else:
                l3.next = ListNode(l2.val)
                l2 = l2.next
            l3 = l3.next
        while l1 is not None:
            l3.next = ListNode(l1.val)
            l3 = l3.next
            l1 = l1.next
        while l2 is not None:
            l3.next = ListNode(l2.val)
            l2 = l2.next
            l3 = l3.next
        return l3_head.next

s = Solution()
l1 = ListNode(1)
l11 = l1
l1.next= ListNode(2)
l1 = l1.next
l1.next= ListNode(4)
l1 = l1.next

l2 = ListNode(1)
l22 = l2
l2.next= ListNode(3)
l2 = l2.next
l2.next= ListNode(4)
l2 = l2.next
l3 = s.mergeTwoLists(l11, l22)
print(l3)
