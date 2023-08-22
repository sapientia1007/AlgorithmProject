import sys
input = sys.stdin.readline

N = int(input()) # 멀티탭 개수

total = 0
for _ in range(N) :
    n = int(input())
    total += n

print(total - (N-1))