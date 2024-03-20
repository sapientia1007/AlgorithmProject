def solution(seoul):
    idx = 0
    
    for i in seoul : 
        if i == "Kim":
            idx = seoul.index(i)
            answer= f"김서방은 {idx}에 있다"
            
    return answer