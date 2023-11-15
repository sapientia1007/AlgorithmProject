def solution(priorities, location):
    answer = 0
    maxPlace = priorities.index(max(priorities))

    while True :
        value = max(priorities)

        if (priorities[maxPlace] == value) :
            priorities[maxPlace] = 0
            answer += 1

            if maxPlace == location :
                break
        maxPlace += 1
        if (maxPlace >= len(priorities)) :
            maxPlace = 0
    return answer

print(solution([2, 1, 3, 2], 2)) # 1
print(solution([1, 1, 9, 1, 1, 1], 0)) # 5
# location은 몇번째로 실행되는지 알고싶은 프로세스의 위치(인덱스)
