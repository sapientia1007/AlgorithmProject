def solution(array, commands):
    answer = []
    for c in commands : 
        i, j, k = c[0], c[1], c[2]
        newArray = sorted(array[i-1:j])
        if len(newArray) > k :
            answer.append(newArray[k-1])
        else: 
            answer.append(newArray[-1])
    return answer
# i = 배열의 시작, j = 배열의 끝, k = 뽑은 배열을 정렬 후 해당 번째 