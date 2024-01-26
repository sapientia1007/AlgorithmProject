import sys
input = sys.stdin.readline

N = int(input())
i = list(map(int, input().split()))
res = 0

for n in i :
    cnt = 0 
    if n > 1 :
        for ii in range(2, int(n)) :
            if n % ii == 0 :
                cnt += 1
        if cnt ==  0 :
            res += 1

print(res)
