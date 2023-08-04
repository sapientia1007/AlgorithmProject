# ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
# ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]


def solution(record):
    res = dict()
    answer = []
    for i in record :
        if len(i.split(" ")) == 3 :
            res[i.split(" ")[1]] = i.split(" ")[2]
    for i in record :
        if i.split(" ")[0] == "Enter" :
            answer.append(f"{res.get(i.split(' ')[1])}님이 들어왔습니다.")
        elif i.split(" ")[0] == "Leave" :
            answer.append(f"{res.get(i.split(' ')[1])}님이 나갔습니다.")

    return answer

print(solution(["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]))