import sys
input = sys.stdin.readline

# 콜렉션 라이브러리 사용
from collections import Counter

N = int(input())
cardNums = list(map(int, input().split()))
M = int(input())
toFindNums = list(map(int, input().split()))

C = Counter(cardNums)

print(" ".join(f"{C[m]}" if m in C else "0" for m in toFindNums))