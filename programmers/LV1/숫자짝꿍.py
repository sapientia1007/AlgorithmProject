def solution(X, Y):
    answer = ''
    for i in range(9, -1, -1) :
        for _ in range(min(str(X).count(str(i)), str(Y).count(str(i)))) :
            answer += str(i)
    if list(set(answer)) == ['0'] :
        answer = '0'
    elif len(answer) == 0 :
        answer = '-1'
    return answer