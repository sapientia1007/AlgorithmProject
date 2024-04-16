def solution(t, p):
    answer = 0
    lenP, nums = len(p), []
    for i in range(len(t)) :
        if len(str(t)[i:i+lenP]) == lenP : 
            nums.append(str(t)[i:i+lenP])
    
    for n in nums : 
        if int(n) <= int(p) :
            answer += 1
    
    return answer