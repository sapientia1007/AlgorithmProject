import sys
from collections import deque
input = sys.stdin.readline

res = deque([i+1 for i in range(int(input()))])

while len(res) > 1 :
    res.popleft()
    temp = res.popleft()
    res.append(temp)

print(res[0])