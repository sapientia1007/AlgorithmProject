def solution(id_list, report, k):
    answer = [0 for _ in range(len(id_list))]
    id_dict = dict()
    for id in id_list :
        id_dict[id] = 0

    for ids in list(set(report)) :
        id_dict[ids.split(' ')[1]] += 1

    res = list()
    for key, value in id_dict.items():
        if value >= k:
            res.append(key)

    for i in list(set(report)):
        if i.split(' ')[1] in res :
            answer[id_list.index(i.split(' ')[0])] += 1
    return answer

print(solution(["muzi", "frodo", "apeach", "neo"],
               ["muzi frodo","apeach frodo","frodo neo",
                "muzi neo","apeach muzi"], 2)) # [2,1,1,0]

print(solution(["con", "ryan"], ["ryan con", "ryan con", "ryan con", "ryan con"], 3)) #[0,0]