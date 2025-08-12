"""
? Check Permutation: Given two strings, write a method to decide if one is a permutation of the
other.
Hints: #7, #84, #722, #737
"""
from collections import defaultdict
def isPermutation(s1: str, s2: str) -> bool:
    s1 = s1.strip()
    s2 = s2.strip()
    if (len(s1) != len(s2)) or len(s1) == 0: return False
    # Use frequencies table

    d1 = defaultdict(int)
    d2 = defaultdict(int)
    for c in s1:
        d1[c] += 1
    for c in s2:
        d2[c] += 1

    return d1 == d2



assert isPermutation("123", "321")
assert isPermutation("123", "421") == False
assert isPermutation("422", "242")
assert isPermutation("422", "442") == False
assert isPermutation("", "442") == False
assert isPermutation("442", "") == False
assert isPermutation("", "") == False
print("AC")
