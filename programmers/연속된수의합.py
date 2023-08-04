def solution(num, total):
    # num = 사용할 숫자 개수
    # total = 합

    for i in range(num):
        total -= i
    startN = total / num
    answer = []
    for i in range(num):
        answer.append(startN + i)
    return answer