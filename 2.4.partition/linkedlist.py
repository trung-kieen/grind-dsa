class Node:
    def __init__(self, data: int):
        self.data = data
        self.next = None
    def __str__(self) -> str:
        return str(self.data)

class LinkedList:
    def __init__(self) -> Node:
        self.head = None
    def append_to_head(self, value: int):
        n = Node(value)
        n.next = self.head
        self.head = n

    def remove(self, node: Node) -> bool:
        if node is None or node.next is None:
            return False
        # Copy next value of current node then remove it
        node.data = next.data
        node.next = node.next.next
        return True

    def append_to_tail(self, value: int):
        if self.head == None:
            self.head = Node(value)
            return self.head
        n = self.head
        while n.next is not None:
            n = n.next
        # if found the end => append value
        n.next = Node(value)
        return n.next
    def __str__(self) -> str:
        nodes = []
        n = self.head

        while n is not None:
            nodes.append(str(n))
            n = n.next
        return "->".join(nodes)

    def remove(self, value: int):
        """
        In place remove
        """
        if self.head.data == value:
            # move to next point
            self.head = self.head.next
            return
        n = self.head.next
        while n.next is not None:
            if n.next.data == value:
                # Skip next value  => remove
                n.next = n.next.next
            # Move next
            n = n.next

