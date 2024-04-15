def solution(n):
    answer=0
    terNum = ''
    while n>1 : 
        terNum += str(n%3)
        n//=3
    if n == 1 :
        terNum += str(n)
    else :
        pass
    
    for idx, i  in enumerate(terNum[-1::-1]) : 
        idx, i = int(idx), int(i)
        answer += (3**idx)*i
    return answer


