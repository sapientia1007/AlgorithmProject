def solution(numbers):
    nums = list(range(0,10))
    for i in numbers : 
        if i in nums  :
            nums.remove(i)

    answer = sum(nums)
    return answer