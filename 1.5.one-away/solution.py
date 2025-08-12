
from collections import defaultdict
"""
Assumption: no case sensitive
"""
class Solution:
    def one_away(self, s1: str, s2: str) -> bool:
        # Exist not same length over 1 character => return false any way
        if abs(len(s1) - len(s2)) > 1:
            return False

        f = defaultdict(int)
        for c in s1:
            f[c] += 1
        for c in s2:
            f[c] -= 1
        total_diff = sum([abs(f[k]) for k in f])

        if  total_diff == 0:
            return True
        # Same length
        if len(s1) == len(s2):
            # same length => replace character
            return total_diff <= 2
        else:
            # Insert and remove
            return total_diff <= 1





s = Solution()
assert s.one_away("pale", "ple")
"""
{
'p': 2
'a': 1
'l': 1
'e': 1
}
Not exist 'a' => one diff
Len: 4 - 1 == 3
{
'p': 1
'a': 1
'l': 1
'e': 1
}
"""

assert s.one_away('pale', 'bale')


assert s.one_away("ple", "pale")
assert s.one_away("pale", "pale")
assert not s.one_away("paleee", "pale")
assert not s.one_away("palaee", "pale")


assert s.one_away("pale", "ple")
assert s.one_away("pales", "pale")
assert s.one_away("pale", "bale")
assert not s.one_away("pale", "bake")
assert s.one_away("pale", "pales")
assert s.one_away("pale", "pale")
assert not s.one_away("abc", "abcde")
assert s.one_away("a", "b")
assert s.one_away("a", "ab")
assert s.one_away("abc", "adc")


"""
{
'p': 1
'a': 1
'l': 1
'e': 1
}

{
'b': 1
'a': 1
'l': 1
'e': 1
}
Not exist 'p' but exist 'p'
Len: 4 == 4
"""


"""
How to check if insert or remove
f1 = {
'p': 2
'a': 1
'l': 1
'e': 1
}
f2 = {
'p': 1
'a': 1
'l': 1
'e': 1
}
Insert
from f1 and f2 => {
'p': 1
'a': 0
'l': 0
'e': 0
}

Reverse if remove
from f2  and f1 => {
'p': -1
'a': 0
'l': 0
'e': 0
}
=> abs(character_diff ) = <= 1
"""


"""
What about replace ?
abs(character_diff ) = <= 2
"""
print("AC")
