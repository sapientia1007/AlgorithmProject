def solution(numbers):
    answer = ''
    numbers = list(map(str, numbers))
    numbers.sort(key = lambda x : x*3, reverse=True)
    answer = str(int(answer.join(numbers)))
    return answer

# 각 숫자를 세 번 반복하여 비교하고, 그 결과를 기준으로 정렬합니다. 이렇게 함으로써 숫자의 크기를 비교할 때, 숫자의 자릿수를 고려한 정렬이 가능해집니다.