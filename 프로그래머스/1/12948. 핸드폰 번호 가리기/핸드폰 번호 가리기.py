def solution(phone_number):
    answer = ''
    idx = len(phone_number)-4
    for i in range(idx) : 
        answer += "*"
    answer += phone_number[-4::]
    return answer