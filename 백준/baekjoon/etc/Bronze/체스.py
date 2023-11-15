res = [1, 1, 2, 2, 2, 8]

inputStr = list()
for i in map(int, input().split()) :
    inputStr.append(i)

for i in range(len(res)) :
    print(res[i]-inputStr[i], end=' ')