from collections import Counter
def solution(k, tangerine):
    answer = 0
    tDict = Counter(tangerine)
    tDictValues = sorted(tDict.values(), reverse=True)
    if k in tDictValues : 
        answer = 1
    else :
        for v in tDictValues :
            k-=v
            answer += 1
            if k<=0 : 
                break
    return answer