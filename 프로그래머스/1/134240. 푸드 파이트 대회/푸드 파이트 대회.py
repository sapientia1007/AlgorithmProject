def solution(food):
    answer = ''
    
    for idx, num in enumerate(food):
        if idx == 0 :
            pass
        else :
            for _ in range(num//2) :
                answer+= str(idx)
    answer = (answer + "0" + answer[-1::-1])
    return answer