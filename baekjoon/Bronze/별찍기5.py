N = int(input())

total = 2*N-1
for n in range(1, N+1) :
    print(" "*((total-(2*n-1))//2), "*" * (2*n-1), sep="")