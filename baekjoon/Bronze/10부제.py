day = int(input())

cars = list(map(int, input().split()))

cnt = 0

for car in cars :
    if int(str(car)[-1]) == day :
        cnt += 1

print(cnt)