def solution(clothes):
    answer = 1
    cloth_dict = {}
    for v, k in clothes :
        if not k in cloth_dict :
            cloth_dict[k] = 0
        cloth_dict[k] += 1
    print(cloth_dict)

    for i in cloth_dict.values() :
        answer *= i + 1

    return answer - 1
