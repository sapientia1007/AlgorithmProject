numbers = {}
for i in range(0, 10) :
    numbers[i] = 0

a = int(input())
b = int(input())
c = int(input())

res = a*b*c

for n in str(res) :
    numbers[int(n)] += 1

for value in numbers.values():
    print(value)