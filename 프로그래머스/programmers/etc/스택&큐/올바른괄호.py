def solution(s):
    answer = []
    for i in s :
        if i == "(" :
            answer.append(i)
        elif i == ")" :
            try :
                answer.pop()
            except :
                return False
    if len(answer) == 0 :
        return True
    else :
        return False
