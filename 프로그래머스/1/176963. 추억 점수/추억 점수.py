def solution(name, yearning, photo):
    answer = []
    for photos in photo : 
        photoSum = 0
        for sinPhoto in photos : 
            if sinPhoto in name : 
                photoSum += yearning[name.index(sinPhoto)]
        answer.append(photoSum)
    return answer