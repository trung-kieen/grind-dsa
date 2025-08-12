from linkedlist import LinkedList

ll = LinkedList()
ll.append_to_tail(10)
ll.append_to_tail(10)
ll.append_to_tail(12)
class Solution:
    def remove_dups(self, ll: LinkedList):
        values = set()
        if ll.head is None:
            return
        n = ll.head
        values.add(n.data)
        while n.next is not None:
            if n.next.data in values:
                # Remove node because dups
                n.next = n.next.next
            else:
                # Add value to list
                values.add(n.next.data)
            # Move to next node
            n = n.next


s= Solution()
s.remove_dups(ll)
assert str(ll) == "10->12"
