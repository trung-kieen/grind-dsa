from typing import List
import unittest

"""


"""
class Solution:
    def rotate_matrix(self,  m: List[List[int]]) -> bool:
        n = len(m)
        if n == 0 or n != len(m[0]):
            return False
        for layer in range(0,n // 2 ):
            for offset in range(layer, n - 1 - layer):
                # Swap 4 value in clock wise
                # Temp =  top
                temp=m[layer][layer+offset]
                # Top = left
                m[layer][layer+offset]=m[n-1-layer-offset][layer]
                # Left = bottom
                m[n-1-layer-offset][layer]=m[n-1-layer][n-1-layer-offset]
                # Bottom = right
                m[n-1-layer][n-1-layer-offset]=m[layer+offset][n-1-layer]
                # right = temp
                m[layer+offset][n-1-layer]=temp

        return True

def print_matrix(matrix: List[List[int]]) -> None:
    """Helper function to print matrix in a readable format."""
    if not matrix:
        print("Empty matrix")
        return
    for row in matrix:
        print(row)
    print()

class TestRotateMatrix(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_3x3_matrix(self):
        matrix = [
            [1, 2, 3],
            [4, 5, 6],
            [7, 8, 9]
        ]
        expected = [
            [7, 4, 1],
            [8, 5, 2],
            [9, 6, 3]
        ]
        print("Before rotation (3x3):")
        print_matrix(matrix)
        result = self.solution.rotate_matrix(matrix)
        print("After rotation (3x3):")
        print_matrix(matrix)
        self.assertTrue(result)
        self.assertEqual(matrix, expected)

    def test_4x4_matrix(self):
        matrix = [
            [ 1,  2,  3,  4],
            [ 5,  6,  7,  8],
            [ 9, 10, 11, 12],
            [13, 14, 15, 16]
        ]
        expected = [
            [13,  9,  5,  1],
            [14, 10,  6,  2],
            [15, 11,  7,  3],
            [16, 12,  8,  4]
        ]
        print("Before rotation (4x4):")
        print_matrix(matrix)
        result = self.solution.rotate_matrix(matrix)
        print("After rotation (4x4):")
        print_matrix(matrix)
        self.assertTrue(result)
        self.assertEqual(matrix, expected)

    def test_1x1_matrix(self):
        matrix = [[1]]
        expected = [[1]]
        print("Before rotation (1x1):")
        print_matrix(matrix)
        result = self.solution.rotate_matrix(matrix)
        print("After rotation (1x1):")
        print_matrix(matrix)
        self.assertTrue(result)
        self.assertEqual(matrix, expected)

    def test_empty_matrix(self):
        matrix = []
        print("Empty matrix test:")
        print_matrix(matrix)
        result = self.solution.rotate_matrix(matrix)
        self.assertFalse(result)
        print("No change expected\n")

    def test_non_square_matrix(self):
        matrix = [
            [1, 2, 3],
            [4, 5, 6]
        ]
        print("Non-square matrix (2x3):")
        print_matrix(matrix)
        result = self.solution.rotate_matrix(matrix)
        self.assertFalse(result)
        print("No change expected\n")

    def test_2x2_matrix(self):
        matrix = [
            [1, 2],
            [3, 4]
        ]
        expected = [
            [3, 1],
            [4, 2]
        ]
        print("Before rotation (2x2):")
        print_matrix(matrix)
        result = self.solution.rotate_matrix(matrix)
        print("After rotation (2x2):")
        print_matrix(matrix)
        self.assertTrue(result)
        self.assertEqual(matrix, expected)

# if __name__ == '__main__':
#     unittest.main()



matrix = [
[ 1,  2,  3,  4],
[ 5,  6,  7,  8],
[ 9, 10, 11, 12],
[13, 14, 15, 16]
]
s = Solution()
s.rotate_matrix(matrix)
print_matrix(matrix)
