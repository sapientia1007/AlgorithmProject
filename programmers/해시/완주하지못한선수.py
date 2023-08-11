# 복습 필요
def solution(participant, completion):
    answer = ''
    playerDict = {}

    for name in participant :
        if name not in playerDict :
            playerDict[name] = 0
        else :
            playerDict[name] += 1

    for name in completion :
        if playerDict[name] == 0 :
            playerDict.pop(name)
        else :
            playerDict[name]-= 1

    answer = list(playerDict.keys())[0]
    return answer