T = input()
intLst = [0]
tLst = [int(t) for t in T]
intLst.extend(tLst)

res = 0 
while True :
    intLst.append(int(str(intLst[-1] + intLst[-2])[-1]))
    newInt = int(str(intLst[-2]) + str(intLst[-1]))
    res += 1
    if newInt == int(T) :
        break

print(res)