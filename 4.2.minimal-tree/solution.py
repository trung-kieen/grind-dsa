class Node:
    def __init__(self, data, left = None, right = None):
        self.data = data
        self.left = left
        self.right = right

    def __str__(self, level=0):
        ret = ""
        if self.right:
            ret += self.right.__str__(level + 1)
        ret += "    " * level + f"{self.data}\n"
        if self.left:
            ret += self.left.__str__(level + 1)
        return ret

class Solution:
    def minimal_tree(self, lst):
        return self.build_tree(lst)


    # Return the node perspective
    def build_tree(self, lst, left = 0, right = None):
        if right is None:
            right = len(lst) - 1
        if left > right:
            return None
        mid = (right + left) // 2
        n =  Node(lst[mid])
        n.left = self.build_tree(lst, left, mid - 1)
        n.right = self.build_tree(lst, mid + 1, right)
        return n



s = Solution()
rs = s.build_tree([1, 2, 3, 4, 5, 6, 7, 8, 9])
print(rs)

