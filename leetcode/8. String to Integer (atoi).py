class Solution:
    MAX = 2147483647
    MIN = -2147483648

    def myAtoi(self, str):
        str = str.strip()

        if len(str) == 0 or str == None:
            return 0
        firstCh = str[0]
        if (firstCh != '+' and firstCh != '-' and not firstCh.isdigit()):
            return 0
        if (not firstCh.isdigit()):
            str = str[1:]
        index = 0

        while index < len(str):
            if (not str[index].isdigit()):
                break
            index += 1

        str = str[:index]
        try:
            num = int(str)
        except:
            return 0
        if firstCh == '-':
            num = -num
        if num > self.MAX:
            num = self.MAX
        elif num < self.MIN:
            num = self.MIN

        return num


s = Solution()
s.myAtoi(" ")