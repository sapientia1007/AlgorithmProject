def solution(s):
    resList=  []
    strList = s.split(" ")
    
    for voca in strList :
        answer = ''
        if voca != "" : 
            for idx, v in enumerate(voca) :
                if idx % 2 == 0 :
                    answer += v.upper()
                else : 
                    answer += v.lower()
        resList.append(answer)

    return " ".join(resList)