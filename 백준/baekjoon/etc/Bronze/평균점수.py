res = 0
for _ in range(5) :
    n = int(input())
    if n < 40 :
        res += 40
    else :
        res += n
print(int(res/5))