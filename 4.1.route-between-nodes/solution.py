# This is graph node => linked to other node
class Node:
    def __init__(self, val):
        self.val = val
        self.neighbors = []



    def __eq__(self, other):
        return type(other) == type(self) and other.val == self.val

class Solution:
    def __route_between_nodes(self, start, end):
        """
        Return if the first node linked to the end node
        """
        if start == end:
            return True
        # Create the visited list to avoid cycle
        # Start the queue with start node
        visited = set()

        # Traversal all node in the graph
        q = [start]
        while q:
            n = q.pop(0)
            visited.add(n.val)
            if n == end:
                return True

            for child in n.neighbors:
                if child.val not in visited:
                    q.append(child)
        # If catch the end node return found signal

        # Perform bfs

        return False


