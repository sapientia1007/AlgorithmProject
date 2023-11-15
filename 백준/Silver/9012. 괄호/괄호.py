n = int(input())

for _ in range(n) :
    res = []
    isVPS = str(input())
    for i in isVPS : 
        if i == "(" : 
            res.append(i)
        elif i == ")" : 
            if len(res) == 0 :
                print("NO")
                break
            else :
                res.pop()
    else : 
        if len(res) == 0 :
            print("YES")
        else : 
            print("NO")