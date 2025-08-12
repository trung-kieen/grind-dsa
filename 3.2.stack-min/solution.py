"""
Approach 2: store the min value in each moment
=> After pop will still know min value with the top of stack
The down side is cost fully O(n) in memory
"""
class StackMin:
    def __init__(self):
        self.data = []
        self.min_value = float('inf')
    def push(self, value):
        self.min_value = min(self.min_value, value)
        self.data.append((value, self.min_value))

    def pop(self):
        if len(self.data) == 0:
            return None
        value, _ = self.data.pop()
        self.min_value = self.data[-1][1]
        return value
    def min(self):
        if len(self.data) == 0:
            return None
        return self.min_value

    def __str__(self) -> str:
        return str(self.data)


def log(s: StackMin, action: str):
    print("Perform " + action + " " , s, " min is ", s.min())

s = StackMin()
s.push(5)
log(s, "push 5")
assert s.min() == 5
s.push(6)
log(s, "push 6")
assert s.min() == 5
s.push(3)
log(s, "push 3")
assert s.min() == 3
s.push(7)
log(s, "push 7")
assert s.min() == 3
s.pop()
log(s, "push pop")
assert s.min() == 3
s.pop()
assert s.min() == 5

log(s, "push pop")

