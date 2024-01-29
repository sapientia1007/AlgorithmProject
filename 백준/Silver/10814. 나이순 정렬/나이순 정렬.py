import sys
input = sys.stdin.readline

N = int(input())

res = []
for _ in range(N) :
    age, name = map(str, input().split())
    res.append([age, name])

res.sort(key=lambda member : (int(member[0])))

for age, name in res:
    print(age, name)