class Solution:

    def isChMatch(self, c, p):
        return c == p or p == '.'

    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        if len(p) == 0:
            return len(s) == 0
        if len(p) == 1:
            return len(s) == 1 and self.isChMatch(s[0], p[0])
        if p[1] != '*':
            if (len(s) == 0):
                return False
            return self.isChMatch(s[0], p[0]) and self.isMatch(s[1:], p[1:])
        while len(s) != 0 and self.isChMatch(s[0], p[0]):
            if self.isMatch(s, p[2:]):
                return True
            s = s[1:]
        return self.isMatch(s, p[2:])


s = Solution()
print(s.isMatch("ab", ".*"))
print(s.isMatch("aab", "c*a*b"))
print(s.isMatch("mississippi", "mis*is*p*."))
print(s.isMatch("aa", "a*"))
