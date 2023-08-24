t = int(input())
for _ in range(t) :
    i, s = input().split()
    for w in str(s) :
        print(w*int(i), end="")
    print()