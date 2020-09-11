class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:

        obs = set(map(tuple, obstacles))
        dir = ((0,1), (1,0), (0,-1), (-1,0))

        d, x, y, max_dis = 0, 0, 0, 0

        for step in commands:
            if step == -1:
                d = d + 1 if d < 3 else 0
            elif step == -2:
                d = d - 1 if d > 0 else 3
            else:
                for _ in range(step):
                    if (x + dir[d][0], y + dir[d][1]) not in obs:
                        x, y = x + dir[d][0], y + dir[d][1]
                max_dis = max(max_dis, x*x + y*y)
        return max_dis
