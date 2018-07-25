class Solution:
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if (strs == None or len(strs) == 0):
            return ""
        min_len = min([len(x) for x in strs])
        if (min_len == 0):
            return ""
        for i in range(1, min_len + 1):
            for j in range(len(strs[:-1])):
                if (strs[j][0:i] != strs[j + 1][0:i]):
                    if (i == 0):
                        return ""
                    else:
                        return strs[j][0:i - 1]
        return strs[0][:min_len]


s = Solution()
print(s.longestCommonPrefix(["aa", "a"]))
