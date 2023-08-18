cnt = int(input())
res = 0
num = input()

for i in range(len(num)) :
    res += int(str(num)[i])

print(res)