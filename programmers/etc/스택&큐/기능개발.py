def solution(progresses, speeds):
    answer = []
    cnt = 0 # 완료된 기능
    days = 0 # 날짜

    while len(progresses) > 0 :
        if (progresses[0]+days*speeds[0]) >= 100 : # 완료
            progresses.pop(0) # 완료 -> 리스트에서 항목 제거
            speeds.pop(0)
            cnt += 1
        else :
            if cnt > 0 :
                answer.append(cnt)
                cnt = 0
            else :
                days += 1
    answer.append(cnt)
    return answer

print(solution([93, 30, 55], [1, 30, 5])) # [2,1]
print(solution([95, 90, 99, 99, 80, 99], [1, 1, 1, 1, 1, 1])) # [1, 3, 2]