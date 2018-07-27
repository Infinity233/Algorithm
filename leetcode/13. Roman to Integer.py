class Solution:
    # I, V, X, L, C, D, M = 1, 5, 10, 50, 100, 500, 1000
    v = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}

    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        res = 0
        s = list(s)
        while len(s) != 0:
            t = s[0]
            if len(s) == 1:
                res += self.v.get(t)
            elif t == 'I' and (s[1] == 'V' or s[1] == 'X'):
                if s[1] == 'V':
                    res += 4
                else:
                    res += 9
                s.remove(s[0])
            elif t == 'X' and (s[1] == 'L' or s[1] == 'C'):
                if s[1] == 'L':
                    res += 40
                else:
                    res += 90
                s.remove(s[0])
            elif t == 'C' and (s[1] == 'D' or s[1] == 'M'):
                if s[1] == 'D':
                    res += 400
                else:
                    res += 900
                s.remove(s[0])
            else:
                res += self.v.get(t)
            s.remove(s[0])
        return res


s = Solution()
print(float('inf'))
while True:
    t = input()
    print(s.romanToInt(t))
