def solution(d, budget):
    d = sorted(d)
    answer = 0
    if sum(d) <= budget : 
        answer = len(d)
    else : 
        for i in range(0, len(d)) :
            if d[i] <= budget : 
                answer += 1
                budget -= d[i]
    return answer