from collections import Counter
def solution(a, b, c, d):
    res = Counter([a,b,c,d]).most_common(4)
    resList = list()
    for i in res :
        resList.append(i)
    if resList[0][1] == 4 :
        answer = resList[0][0] * 1111
    elif resList[0][1] == 3 :
        answer = (resList[0][0] * 10 + resList[1][0])**2
    elif resList[0][1] == 2 :
        if resList[1][1] == 2 :
            answer = (resList[0][0] + resList[1][0]) * abs(resList[0][0]-resList[1][0])
        else :
            answer = resList[1][0] * resList[2][0]
    else :
        answer = min(a,b,c,d)
    return answer


