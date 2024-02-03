import sys
input = sys.stdin.readline

while True :
    x = str(input())
    if int(x) == 0 :
        break
    else:
        xRev = x[::-1]
        if int(x) == int(xRev) :
            print("yes")
        else :
            print("no")