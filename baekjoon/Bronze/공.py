M = int(input())

ballList = [1, 0, 0]

for _ in range(M):
    x, y = map(int, input().split())
    x -= 1
    y -= 1
    temp = ballList[x]
    ballList[x] = ballList[y]
    ballList[y] = temp

print(ballList.index(1)+1)