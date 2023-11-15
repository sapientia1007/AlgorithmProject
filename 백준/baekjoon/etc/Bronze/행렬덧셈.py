# 복습 필요
A, B = [], []
r, c = map(int, input().split())

for row in range(r) :
    row = list(map(int, input().split()))
    A.append(row)

for row in range(r) :
    row = list(map(int, input().split()))
    B.append(row)

for row in range(r) :
    for col in range(c) :
        print(A[row][col] + B[row][col], end=' ')
    print()