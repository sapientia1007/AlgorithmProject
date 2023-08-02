# 정수를 나선형으로 배치하기
"""
양의 정수 n이 매개변수로 주어집니다. n × n 배열에 1부터 n2 까지 정수를 인덱스 [0][0]부터 시계방향 나선형으로 배치한 이차원 배열을 return 하는 solution 함수를 작성해 주세요.
"""

def solution(n):
    snake = [n]
    d = ((0, 1), (1, 0), (0, -1), (-1, 0))
    answer = [[0 for i in range(n)] for j in range(n)]
    count, x, y = 0, -1, 0

    while n > 1:
        n -= 1
        snake.append(n)
        snake.append(n)

    for i in range(len(snake)):
        for j in range(snake[i]):
            y += d[i % 4][0]
            x += d[i % 4][1]
            count += 1
            answer[y][x] = count

    return answer