def solution(s):
    arr = ['zero', 'one', 'two', 'three', 'four', 
               'five', 'six', 'seven', 'eight', 'nine']

    answer = ''
    finN = ''
    for i in s :

        if (i.isnumeric()) : 
            answer += str(i)
        else : 
            finN += str(i)
            if finN in arr  :
                answer += str(arr.index(finN))
                finN =''
    return int(answer)