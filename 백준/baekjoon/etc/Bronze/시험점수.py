res = list()
for _ in range(2) :
    scores = list(map(int, input().split()))
    res.append(sum(scores))

print(max(res))