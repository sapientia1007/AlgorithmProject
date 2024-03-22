def solution(n, m):
    answer = []

    minNum = min(n,m)
    maxNum = max(n,m)

    
    # 최대공약수    
    for i in range(minNum, 0, -1) : 
        if minNum % i == 0 and maxNum%i == 0 :
            answer.append(i)
            break
            
    # 최소공배수
    for i in range(maxNum, n*m+1) :
        if i%minNum == 0 and i%maxNum == 0 :
            answer.append(i)
            break
    
                    
    return answer