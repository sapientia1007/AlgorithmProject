T = int(input())
res = T
for _ in range(T) :
    word = str(input())
    wordLst = []
    for w in word :
        if w in wordLst and wordLst[-1] != w :
            res-=1
            break
        if w not in wordLst :
            wordLst.append(w)

print(res)