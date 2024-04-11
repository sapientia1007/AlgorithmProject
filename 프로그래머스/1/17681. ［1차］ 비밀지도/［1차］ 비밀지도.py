def solution(n, arr1, arr2):
    answer = []
    for a in range(n) : 
        res = ''
        for _ in range(n) :
            # arr1 
            num = str(arr1[a]%2)
            arr1[a] = arr1[a]//2 
            
            # arr2
            num2 = str(arr2[a]%2)
            arr2[a] = arr2[a]//2
            if int(num) == 0 and int(num2) == 0 :
                res += " "
            else  :
                res += "#"
        answer.append(res[-1::-1])
    return answer