x = int(input())
cnt = 0
for i in range(1, x+1) :
    if i < 100 :
        cnt += 1
    else :
        if int(str(i)[1])-int(str(i)[0]) == int(str(i)[2])-int(str(i)[1]) :
            cnt += 1
print(cnt)
