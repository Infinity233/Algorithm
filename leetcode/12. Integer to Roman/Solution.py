class Solution:
    int_to_roman_mapping = {1: "I", 5: "V", 10: "X", 50: "L", 100: "C", 500: "D", 1000: "M"}
    mapping49 = {4: "IV", 9: "IX", 40: "XL", 90: "XC", 400: "CD", 900: "CM"}
    numList = [1000, 100, 10, 1]

    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        res = ""
        for base in self.numList:
            f = num // base
            if f != 0:
                if f in self.mapping49:
                    res += self.mapping49.get(f * base)
                else:
                    if num >= base * 5:
                        res += self.int_to_roman_mapping.get(base * 5)
                        num -= base * 5
                        f = num // base
                    while f != 0:
                        res += self.int_to_roman_mapping.get(base)
                        f -= 1
                num -= base * (num // base)
        return res
