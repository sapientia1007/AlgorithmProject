## 시간초과 해결을 위한 stdin 사용
from sys import stdin

for _ in range(3) :
    res = 0
    N = int(stdin.readline())
    for _ in range(N) :
        inputNum = int(stdin.readline())
        res += inputNum

    if res == 0 :
        print("0")
    elif res > 0 :
        print("+")
    elif res < 0 :
        print("-")