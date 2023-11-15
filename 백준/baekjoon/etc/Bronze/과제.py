student = [i for i in range(1, 31)]

for _ in range(0, 28) :
    student.remove(int(input()))

for i in student :
    print(i)