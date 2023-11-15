eng = input()
res = ""
for i in eng :
    if i.isupper() :
        i = i.lower()
        res += i
    elif i.islower() :
        i = i.upper()
        res += i
print(res)