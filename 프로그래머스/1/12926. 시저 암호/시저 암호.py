def solution(s, n):
    dict = ['a','b','c','d','e','f','g','h',
            'i','j','k','l','m','n','o','p','q',
            'r','s','t','u','v','w','x','y','z']
    answer = ''

    for i in s : 
        if i != " " :
            if i.islower() : 
                idx = dict.index(i)
                newidx = (idx+n) % len(dict)
                answer += str(dict[newidx])
            elif i.isupper() :
                idx = dict.index(i.lower())
                newidx = (idx+n) % len(dict)
                answer += str(dict[newidx]).upper()
        else : 
            answer += " "
    return answer