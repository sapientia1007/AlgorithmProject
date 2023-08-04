import itertools

def check(number) :
    cnt = 0
    for i in range(2, number) :
        if number % i == 0 :
            cnt += 1
    return cnt

def solution(nums):
    answer = 0
    three_list = list(itertools.combinations(nums,3))
    for i in three_list :
        if check(sum(i)) == 0 :
            answer += 1
    return answer