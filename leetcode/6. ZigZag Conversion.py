class Solution:

    def convert(self, s, numRows):
        top_index = []
        index = 0
        t = (numRows - 1) * 2
        res = ""

        while index < len(s):
            top_index.append(index)
            res += s[index]
            index += t

        for i in list(range(1, numRows - 1)):

            for j in top_index:
                t = j - i
                if self.check_str(self, t, s):
                    res += s[t]

                t = j + i
                if not self.check_str(self, t, s):
                    continue
                res += s[t]

        for i in top_index:
            t = i + numRows - 1
            if self.check_str(t, s):
                res += s[t]

        return res

    def check_str(self, index, s):
        if index < 0 or index >= len(s):
            return False
        return True


t = Solution()
print(t.convert(None, "PAYPALISHIRING", 4))
