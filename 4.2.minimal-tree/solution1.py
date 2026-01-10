class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None
class Solution:
    def _create_bst(self, values, start, end):
        if end - start < 0:
            return None
        if end - start == 0:
            return Node(values[0])
        mid = (end + start) // 2

        n = Node(values[mid])
        n.left = self._create_bst(values, start, mid - 1)
        n.right = self._create_bst(values, mid + 1, end)

        return n


    def create_bst(self, values):
        return self._create_bst(values, 0, len(values) - 1)
