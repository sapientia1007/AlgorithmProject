N = input()
res = 0
for i in N.split(' ') :
    res += (int(i)**2)
print(res%10)