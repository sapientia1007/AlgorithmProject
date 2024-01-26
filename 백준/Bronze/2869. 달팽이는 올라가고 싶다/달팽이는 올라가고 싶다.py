import sys
input = sys.stdin.readline

A, B, V = list(map(int, input().split()))

res, cnt = 0, 0

if V < A :
    print(1)
else :
    if (V-A) % (A-B) == 0 :
        print((V-A) // (A-B) + 1)
    else :
        print((V - A) // (A - B) + 2)


