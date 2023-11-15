N = int(input())
times = list(map(int, input().split()))
resM, resY = 0, 0

# 영식 요금제 - 30초마다 10원씩
for time in times :
    if (time < 30) :
        resY += 10
    else :
        resY += (time // 30 + 1) * 10

# 민식 요금제 - 60초마다 15원씩
for time in times:
    if (time < 60) :
        resM += 15
    else:
        resM += (time // 60 + 1) * 15

if resY < resM :
    print(f"Y {resY}")
elif resY > resM :
    print(F"M {resM}")
else :
    print(f"Y M {resY}")