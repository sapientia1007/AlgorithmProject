import sys
input = sys.stdin.readline

K = int(input())

res = []

for _ in range(K) :
    i = int(input())
    if i == 0 :
        res.pop()
    else :
        res.append(i)

print(sum(res))