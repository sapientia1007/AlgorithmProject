def solution(n):
    if n < 3 : 
        return n
    res = [0] * (n+1) 
    res[1], res[2] = 1, 2

    for i in range(3, n+1) :
        res[i] = res[i-1] + res[i-2]
        
    return res[n] % 1234567