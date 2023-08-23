total, maxP = 0, 0
for _ in range(4) :
    outP, inP = map(int, input().split())
    total = total - outP + inP
    if maxP < total :
        maxP = total

print(maxP)