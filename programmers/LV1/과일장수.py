from itertools import combinations

# k : 최대 점수 / m : 한 상자에 들어가는 사과의 수 / score: 사과들의 점수
# 한 상자 사과 점수 : 최저 점수 x 사과 개수(m)
def solution(k, m, score):
    score.sort(reverse=True)
    answer = 0

    for i in range(0, len(score), m) :
        tmp = score[i:i+m]
        if len(tmp) == m :
            answer += (min(tmp)*m)
    return answer


print(solution(3, 4, [1,2,3,1,2,3,1]))