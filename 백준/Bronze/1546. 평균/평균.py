import sys
input = sys.stdin.readline

N = int(input())
i = list(map(int, input().split()))
maxScore = max(i)

res = 0
for ii in i :
    ii = ii/maxScore*100
    res += ii

print(res/N)
