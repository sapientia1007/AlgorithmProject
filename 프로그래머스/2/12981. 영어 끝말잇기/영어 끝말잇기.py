def solution(n, words):
    answer = [] 
    cnt = 1
    res = [0,0]
    
    while len(words) != 0 : 
        if len(answer) == 0 :
            answer.append(words.pop(0))
        elif answer[-1][-1] != words[0][0] : 
            res = [cnt%n+1, cnt//n +1]
            break
        elif words[0] in answer : 
            res = [cnt%n+1, cnt//n +1]
            break
        else : 
            answer.append(words.pop(0))
            cnt+=1
            
    return res