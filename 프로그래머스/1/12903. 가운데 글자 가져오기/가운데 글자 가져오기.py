def solution(s):
    answer = ''

    idx = int(len(s)/2)
    if len(s)%2 == 0 :
        answer += s[idx-1:idx+1] 
    else : 
        answer += s[int(idx)]
    return answer