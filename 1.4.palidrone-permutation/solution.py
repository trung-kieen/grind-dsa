"""
Only care about alphabert character
T is same with t
White space is ignore
"Tact Coa"
{
't': 2
'a': 2
'o': 1
'c': 2
}
=> only one odd of freq => valid palindromePermutation
"""
class Solution:
    def palindromePermutation(self, s: str):
        # Iterate over character
        freq = dict()
        odd_count = 0
        for c in s:
            if c.isalpha():
                key = c.lower()
                freq[key] = freq.get(key, 0) + 1;
                # Track number of odd
                if freq[key] % 2 == 1:
                    odd_count += 1
                else:
                    odd_count -= 1

        # Perfom check if count only 1 odd
        return odd_count <= 1

s = Solution()
assert s.palindromePermutation("Tact Coa")
assert s.palindromePermutation("tact coa")
assert not s.palindromePermutation("tac coa")

print("AC")
