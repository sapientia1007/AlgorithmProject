def solution(a, b, n):
    answer = 0
    
    # a : 콜라를 받기 위해 마트에 주어야하는 병 수
    # b : 빈 명 a 개를 가져다주면 마트가 주는 콜라 병수 b
    # n : 상빈이가 가지고 있는 빈 병의 개수
    
    while n >= a : 
        for i in range(n, 0, -1):
            if i % a == 0 :
                answer += (i//a)*b
                n-=i
                n+=(i//a)*b
                break
            else : 
                pass
    return answer