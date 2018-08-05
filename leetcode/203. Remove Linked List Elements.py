class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        i = head
        pre = None
        while i!= None:
            if i.val == val:
                if pre == None:
                    if i.next == None:
                        return None
                    head = head.next
                    i = head
                else:
                    pre.next = i.next
                    i = pre.next
            else:
                pre = i
                i = i.next
        return head


s = Solution()
list = ListNode(1)
list.next = ListNode(1)
print(s.removeElements(list, 1))