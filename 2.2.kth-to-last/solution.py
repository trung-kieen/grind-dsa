
from linkedlist import LinkedList, Node

class Solution:
    def kth_last(self, ll: LinkedList, k: int):
        result = []
        def append(n: Node) -> None:
            # Base case
            if n.next is None and k > 0:
                result.append(n.data)
                return
            if  k - len(result) > 0:
                append(n.next)
                if k - len(result )> 0:
                    result.append(n.data)
                return

        append(ll.head)
        return result


s = Solution()
ll = LinkedList()
ll.append_to_tail(10)
ll.append_to_tail(11)
ll.append_to_tail(12)
ll.append_to_tail(13)
ll.append_to_tail(14)
rs = s.kth_last(ll, 3)
print(rs)






