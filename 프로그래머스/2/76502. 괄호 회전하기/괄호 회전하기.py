def solution(s):
    strLen = len(s)
    s = s*2
    answer = int(strLen) 
    for i in range(0, strLen) :
        revisedS = s[i:i+strLen]
        paraStack = []
        for p in revisedS : 
            if len(paraStack) == 0 :
                if p == "]" or p =="}" or p ==")" :
                    answer -= 1
                    break
                else : 
                    paraStack.append(p)
            else :
                if paraStack[-1] =="[" and p == "]" :
                    paraStack.pop(-1)
                elif paraStack[-1] =="{" and p == "}" :
                    paraStack.pop(-1)
                elif paraStack[-1] =="(" and p == ")" :
                    paraStack.pop(-1)
                else : 
                    paraStack.append(p)
        if (len(paraStack) != 0) :
            answer -= 1
    return answer