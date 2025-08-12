
class FixedStack:
    def __init__(self, size: int):
        self.data = [0] * size
        # Represent the top index
        self.idx = -1
    def isEmpty(self) -> bool:
        return self.idx < 0
    def isFull(self) -> bool:
        return self.idx == len(self.data) - 1
    def pop(self, pos: int):
        if self.idx < 0:
            return None
        if pos > self.idx:
            raise Exception("Invalid pos, out of bound")
        value = self.data[self.idx]
        self.data[self.idx] = 0
        self.idx -= 1
        return value
    def push(self, value):
        if self.isFull():
            return
        self.idx += 1
        self.data[self.idx] = value
    def peek():
        if self.idx < 0:
            return None
        return self.data[self.idx]


class SetOfStacks:
    stack_size = 10
    def __init__(self):
        self.stack_amount = 1
        self.stacks = [ ]
        self.stack.append(FixedStack(stack_size))
        self.idx = -1
    def push(self):
        pass

    def pop(self, pos: int):

class Solution:
