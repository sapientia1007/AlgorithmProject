import sys
input = sys.stdin.readline

N = int(input())
res = []
for _ in range(N) :
    x, y = map(int, input().split())
    res.append([x,y])

res.sort(key=lambda x : (x[0], x[1])) # 2차원 배열 정렬

for i_x, i_y in res:
    print(i_x, i_y)