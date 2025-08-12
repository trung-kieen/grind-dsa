"""
Algorithsm to sort the stack with runtime O(N^2) and memory O(N)
"""
class Stack:
    def __init__(self):
        self.data = []
    def push(self, value):
        self.data.append(value)
    def pop(self):
        return self.data.pop()

    def is_empty(self):
        return len(self.data) == 0
    def peek(self):
        return self.data[-1]
    def __str__(self):
        return str(self.data)


class Solution:
    def sort_stack(self, s: Stack):
        # Iterate over element in stack s

        temp = []
        while not s.is_empty():
        # Pop value to x
            x = s.pop()
            # While temp is not empty and x < temp.peek we tranfer temp.peek to s
            while len(temp) > 0 and x < temp[-1]:
                s.push(temp.pop())

            # put the value from x to temp
            temp.append(x)
        s.data = temp


a = Stack()
a.data = [2, 5, 1, 7, 3]

s = Solution()
s.sort_stack(a)
assert a.data == [1, 2, 3, 5, 7]
print("AC")
