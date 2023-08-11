while True :
    N, M = map(int, input().split())
    if N > M :
        print("Yes")
    elif N==0 and M== 0 :
        break
    else :
        print("No")
