# Counter.... 복습 필요
from collections import Counter

diceNum = input().split()

res = Counter(diceNum).most_common(3)
resList = list()
for i in res:
    resList.append(i)
if resList[0][1] == 3:
    answer = int(resList[0][0]) * 1000 + 10000
elif resList[0][1] == 2:
    answer = int(resList[0][0]) * 100 + 1000
else:
    answer = int(max(diceNum)) * 100

print(answer)


