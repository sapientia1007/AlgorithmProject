def solution(s):
    res = []
    
    for i in range(len(s)) : 
        if len(res) == 0 :
            res.append(s[i])
        elif res[-1] == s[i] :
            res.pop()
        else : 
            res.append(s[i])
        
    if len(res) == 0 :
        answer = 1
    else : 
        answer = 0
        
    return answer