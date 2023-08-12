l, p = map(int, input().split())
a = list(map(int, input().split()))
total = l*p
res = ""
for n in a :
    res += str(f"{n-total} ")

print(res)

