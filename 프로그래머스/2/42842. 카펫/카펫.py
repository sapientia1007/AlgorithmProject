import math 
def solution(brown, yellow):
    
    answer = []
    
    res = (brown-4)/2 # a+b 
    answer1 = (res + math.sqrt(res*res - 4*yellow))/2 # (a-b)
    answer.append(answer1+2)
    answer2 = res - answer1 
    answer.append(answer2+2)
    
    answer.sort(reverse=True)
    
    return answer