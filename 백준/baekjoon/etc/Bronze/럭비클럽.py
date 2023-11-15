while True :
    inputStr = input().split()
    if inputStr == ['#', '0', '0'] :
        break
    else :
        if int(inputStr[1]) > 17 or int(inputStr[2]) >= 80 :
            print(inputStr[0], "Senior", sep=" ")
        else :
            print(inputStr[0], "Junior", sep=" ")