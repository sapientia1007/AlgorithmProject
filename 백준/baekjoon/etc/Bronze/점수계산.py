n = int(input())
scores = list(map(int, input().split()))
cnt, total = 0, 0
for i in scores :
    if i == 1 :
        cnt += 1
        total += cnt
    elif i == 0 :
        cnt = 0

print(total)