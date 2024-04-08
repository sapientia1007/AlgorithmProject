def solution(s):
    answer = []
    words = {}
    for idx, word in enumerate(s) :
        if word not in words : 
            answer.append(-1)
            words[word] = idx
        else : 
            answer.append(idx-words[word])
            words[word] = idx 
            
    return answer