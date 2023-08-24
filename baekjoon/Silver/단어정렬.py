N = int(input())

res = []
for _ in range(N) :
    res.append(str(input()))

res = list(set(res))
res.sort()
res.sort(key=len)

for w in res :
    print(w)