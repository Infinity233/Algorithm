class Solution:

    def convert(self, s, numRows):
        if numRows == 1:
            return s
        top_index = []
        index = 0
        t = (numRows - 1) * 2
        res = ""

        while index < len(s):
            top_index.append(index)
            res += s[index]
            index += t
        # index -= t
        if index - t + 1 < len(s):
            top_index.append(index)

        for i in list(range(1, numRows - 1)):

            for j in top_index:
                t = j - i
                if self.check_str(t, s):
                    res += s[t]

                t = j + i
                if self.check_str(t, s):
                    # continue
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
assert t.convert("PAYPALISHIRING", 4) == 'PINALSIGYAHRPI'
assert t.convert("PAYPALISHIRING", 3) == 'PAHNAPLSIIGYIR'
assert t.convert("A", 1) == 'A'
assert t.convert("ABCD", 3) == 'ABDC', t.convert("ABCD", 3)
