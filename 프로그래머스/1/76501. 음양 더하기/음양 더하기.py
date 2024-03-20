def solution(absolutes, signs):
    idx = len(signs)-1
    answer = 0
    while idx >= 0 :
        if signs[idx] == True :
            answer += absolutes[idx]
        else : 
            answer -= absolutes[idx]
        idx -=1 
    return answer