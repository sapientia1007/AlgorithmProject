salt = int(input())

res = 0
   
if (salt % 5 == 0) :
    res = (salt // 5) 
    print(res)
else :
    while salt > 0  :
        salt -= 3
        res += 1 
        if (salt % 5 == 0) :
            res += (salt // 5)
            print(res)
            break
        elif salt == 1 or salt == 2 : 
            print(-1)
            break
        elif salt == 0 :
            print(res)
            break