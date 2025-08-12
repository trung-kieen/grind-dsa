class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
    def __str__(self) -> str :
        n=self
        strLst = []
        while n is not None:
            strLst.append(str(n.data))
            n = n.next
        return "->".join(strLst)


class Solution:
    def sum_lists(self, a: Node, b: Node):
        pass

        head = None  # Post to result head
        tail = None


        def add_rs(value):
            nonlocal head
            nonlocal tail
            node = Node(value)
            if head is None:
                tail = node
                head = node
            else:
                tail.next = node
                tail=tail.next


        def sub_sum(a, b, carry=0):
            # Return end of case
            if a is None and b is None and carry == 0:
                return


            total = carry
            if a is not None:
                total +=a.data
            if b is not None:
                total +=b.data

            add_rs(total % 10 )

            next_a = a.next if a is not None else None
            next_b = b.next if b is not None else None
            next_carry = 1 if total >= 10 else 0

            sub_sum(next_a, next_b, next_carry)


            # Sum value if not null

            # Pass next value or null is current number is null
        sub_sum(a, b)
        return head

def create_num(lst):
    # Return head of list number in this (reverse as number value)

    head = None
    if len(lst) == 0:
        return None

    cur = Node(lst[0])
    # Link head to first value
    head = cur
    for v in lst[1:]:
        # Create next value
        cur.next = Node(v)
        # Post current to next value
        cur = cur.next

    return head


x = create_num([9, 2, 9])
y = create_num([3, 5, 2 ])
s = Solution()
rs = s.sum_lists(x, y)
print(rs)

