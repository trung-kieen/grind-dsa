class TreeNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

class Solution:

    def valid_bst(self, root):
        return self._valid_bst(root, float('-inf'), float('inf'))


    # check in separate helper function with bound in min and max
    def _valid_bst(self,node, min_v, max_v):
        if node is None:
            return True

        # end if none

    # Check left < node < right normaly
        if node.left and node.left.data > node.data:
            return False

    # check min < min < max if value is not None
        if node.right and node.right.data < node.data:
            return False


    # check to root node with float("-inf") and float("inf") range
        if not (min_v <=  node.data <= max_v):

            return False


    # If not valid in a node => all other will false

        # Bound current node
        # If turn left => bound max
        # If turn right => bound min
        return self._valid_bst(node.left, min_v, node.data) and self._valid_bst(node.right, node.data, max_v)

