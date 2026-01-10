

class Solution:
    def route_between_two_node(start, end):
        visited = set()
        frontier = [start]

        # start with start endpoint

        # get the top element
        while frontier:
            cur =  frontier.pop(0)
        # check if target end => return solution
            if cur == end:
                return True





        # add to visited

            visited.add(cur)
        # for each node in neighboir => add if not visited
            for nei in cur.neighbors:
                if nei not in visited:
                    frontier.push(nei)

        # if empty => return not route
        return False

