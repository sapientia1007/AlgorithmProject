def solution(A,B):
    res = 0 
    A.sort()
    B.sort()
    
    n = len(A)
    
    for i in range(n) :
        res += (A[i]*B[n-i-1])
    
    return res 