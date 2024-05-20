def solution(elements):
    resElements = []
    n = len(elements)
    repElements = elements * 2
    for i in range(n) :
        for j in range(1, n+1) :
            resElements.append(sum(repElements[i:i+j]))
    resElements = sorted(resElements)
    resElements = set(resElements)
     
    return len(resElements)