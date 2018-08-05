class Solution:
    mapping = {'2': "abc", '3': "def", '4': "ghi", '5': "jkl", '6': "mno", '7': "pqrs", '8': "tuv", '9': "wxyz"}

    def getTimes(self, index, s):
        if index + 1 == len(s):
            return 1
        sum = 1
        for i in s[index + 1:]:
            if i == '7' or i == '9':
                sum *= 4
            else:
                sum *= 3
        return sum

    def letterCombinations(self, digits):
        count79 = 0
        for i in digits:
            if i == '7' or i == '9':
                count79 += 1

        if len(digits) == 0:
            return []
        res = ["" for x in range(pow(3, len(digits) - count79) * pow(4, count79))]

        i, j = 0, 0
        while i < len(digits):
            times = self.getTimes(i, digits)
            ts = self.mapping.get(digits[i])
            idx = 0
            s_idx = 0
            for s in range(len(res)):
                res[s] += ts[s_idx]
                idx += 1
                if idx == times:
                    idx = 0
                    s_idx += 1
                    if s_idx == len(ts):
                        s_idx = 0
            i += 1
        return res


s = Solution()
print(s.letterCombinations("7"))
print(
    ["www", "wwx", "wwy", "wwz", "wxw", "wxx", "wxy", "wxz", "wyw", "wyx", "wyy", "wyz", "wzw", "wzx", "wzy", "wzz",
     "xww", "xwx", "xwy", "xwz", "xxw", "xxx", "xxy", "xxz", "xyw", "xyx", "xyy", "xyz", "xzw", "xzx", "xzy", "xzz",
     "yww", "ywx", "ywy", "ywz", "yxw", "yxx", "yxy", "yxz", "yyw", "yyx", "yyy", "yyz", "yzw", "yzx", "yzy", "yzz",
     "zww", "zwx", "zwy", "zwz", "zxw", "zxx", "zxy", "zxz", "zyw", "zyx", "zyy", "zyz", "zzw", "zzx", "zzy", "zzz"])
