res = []
for _ in range(3) :
    n = int(input())
    res.append(n)
if list(set(res)) == [60] :
    print('Equilateral')
elif sum(res) == 180 and len(set(res)) == 2 :
    print('Isosceles')
elif sum(res) == 180 and len(set(res)) == 3 :
    print('Scalene')
elif sum(res) != 180 :
    print("Error")