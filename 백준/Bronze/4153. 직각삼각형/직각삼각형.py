import sys
input = sys.stdin.readline

while True :
    trianList = sorted(list(map(int, input().split())))

    if sum(trianList) == 0 :
        break
    elif trianList[-1]**2 == trianList[0]**2 + trianList[1]**2 :
        print("right")
    else :
        print("wrong")