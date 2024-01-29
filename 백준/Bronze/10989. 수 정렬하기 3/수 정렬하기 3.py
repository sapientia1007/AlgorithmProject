import sys
input = sys.stdin.readline

res = [0] * 10001
N = int(input())

for _ in range(N) :
    k = int(input())
    res[k] += 1

for i in range(10001) :
    if res[i] != 0 :
        for j in range(res[i]) :
            print(i)