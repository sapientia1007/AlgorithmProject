def solution(s):
    cnt, cnt0 = 0, 0
    
    while s != '1' :
        cnt += 1
        num = s.count("1")
        
        cnt0 += (len(s) - num)
        
        s = bin(num)[2:]
        
    return [cnt, cnt0]