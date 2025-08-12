from linkedlist import LinkedList
class Solution:
    def partition(self, ll: LinkedList, value: int):
        # Use to store value less than head

        part = ll.head

        # Iterate over to find value less than partition value unless end

        while part is not None and part.data < value:
            # Skip the beginning left part value
            part = part.next



        while part is not None:
            if part.next is not None and part.next.data < value:
                ll.append_to_head(part.next.data)
                part.next = part.next.next
            else:
                part = part.next

            # Move next


ll = LinkedList()
ll.append_to_tail(3)
ll.append_to_tail(5)
ll.append_to_tail(8)
ll.append_to_tail(5)
ll.append_to_tail(10)
ll.append_to_tail(2)
ll.append_to_tail(1)
s = Solution()
s.partition(ll, 5)
print(ll)


