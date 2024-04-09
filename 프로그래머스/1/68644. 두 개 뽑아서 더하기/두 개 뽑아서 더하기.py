def solution(numbers):
    idx = len(numbers)
    answer = []
    for i in range(idx) : 
        for j in range(i+1, idx) :
            answer.append(numbers[i] + numbers[j])
    answer = sorted(list(set(answer)))
    return answer