def solution(arr1, arr2):
    answer = []
    idx1, idx2 = len(arr1), len(arr1[0])
    for i in range(0, idx1) : 
        answer1 = []
        for j in range(0, idx2) : 
            answer1.append(arr1[i][j] + arr2[i][j])
        answer.append(answer1)
    return answer