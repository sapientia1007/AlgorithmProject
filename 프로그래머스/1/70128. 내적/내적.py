def solution(a, b):
    answer = 0 
    idx = len(a)
    for i in range(idx) :
        answer += (a[i]*b[i])
    return answer