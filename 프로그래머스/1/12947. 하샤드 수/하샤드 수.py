def solution(x):
    answer = False
    res = 0 
    for i in list(str(x)) :
        res += int(i) 
    if x % res == 0 :
        answer = True
    return answer