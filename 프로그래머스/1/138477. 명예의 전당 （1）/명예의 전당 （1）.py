def solution(k, score):
    answer = [] # 최소 값 리스트
    res = [] # 명예의 전당
    for i in score :         
        if len(res) >= k :
            if res[0] < i : 
                res.pop(0)
                res.append(i)
                res.sort()
                answer.append(res[0])
            else :
                answer.append(res[0])
        else : 
            res.append(i)
            res.sort()
            answer.append(res[0])
        
    return answer