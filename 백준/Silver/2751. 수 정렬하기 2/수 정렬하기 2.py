import sys
input = sys.stdin.readline

N = int(input())
res = []
for _ in range(N) :
    res.append(int(input()))

for i in sorted(res) :
    print(i)