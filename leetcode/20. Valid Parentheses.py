class Solution:
    ch_mapping = {'}': '{', ')': '(', ']': '['}

    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if s == None or len(s) == 0:
            return True
        if len(s) % 2 == 1:
            return False

        stack = []
        for i in s:
            if i not in self.ch_mapping:
                stack.append(i)
            else:
                if len(stack) == 0:
                    return False
                if self.ch_mapping.get(i) != stack.pop():
                    return False
        if len(stack) ==0:
            return True
        else:
            return False


s = Solution()
print(s.isValid("(("))
