class Solution:

    def _judge(self, s, l, r):
        step = 1
        while (l - step) >= 0 and (r + step) < len(s):
            if s[l - step] != s[r + step]:
                break
            step += 1
        wide = r - l + 2 * step - 1
        return wide, l - step + 1

    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        len_1 = len(s) - 1
        if len_1 == 0:
            return s
        i = 0
        max_len = 0
        strInx = 0
        while i < len_1:

            if (s[i] == s[i + 1]):
                l = i
                r = i + 1
                tl, ti = self._judge(s, l, r)
                if tl > max_len:
                    max_len = tl
                    strInx = ti
            l = r = i
            tl, ti = self._judge(s, l, r)
            if tl > max_len:
                max_len = tl
                strInx = ti

            i += 1
        return s[strInx:strInx + max_len]

    def longestPalindrome2(self, s):
        max_len, max_i = 1, 0
        dp = [([0 for x in range(len(s))]) for x in range(len(s))]
        for i in range(len(s)):
            dp[i][i] = 1
        i = 0
        while i < len(s):
            j = 0
            while j < i:
                flag = 0
                if j + 1 == i and s[j] == s[i]:
                    dp[j][i] = 1
                    flag = 1
                elif s[i] == s[j] and dp[j + 1][i - 1] == 1:
                    dp[j][i] = 1
                    flag = 1
                if flag == 1:
                    t = i - j + 1
                    if t > max_len:
                        max_len = t
                        max_i = j
                j += 1
            i += 1
        return s[max_i:max_i + max_len]

    def longestPalindrome3(self, s):
        s = ["#"+x for x in s]
        s+="#"
        s = ''.join(s)
        print(s)


s = Solution()
print(s.longestPalindrome3("babad"))
print(s.longestPalindrome2("a"))
print(s.longestPalindrome2(
    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"))
