p, q = map(int, input().split())

res = []

for i in range(1, p+1) :
    if p%i == 0 :
        res.append(i)

res = sorted(res)
if len(res) < q :
    print("0")
else :
    print(sorted(res)[q-1])