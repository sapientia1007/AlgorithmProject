while True :
    inputStr = input()
    res = 0
    if inputStr == "#" :
        break
    else :
        for i in inputStr :
            if i.lower() in ['a','e','i','o','u'] :
                res += 1
    print(res)