def solution(s):
    arr = list(map(int, s.split()))
    answer = f"{min(arr)} {max(arr)}"
    return answer