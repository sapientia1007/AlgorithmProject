import sys
input = sys.stdin.readline

N, K = map(int, input().split())

res = 1
for i in range(K) :
    res *= N
    N-=1
    
div = 1
for i in range(2, K+1) :
    div *= i

print(res//div)