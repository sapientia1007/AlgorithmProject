t, m = map(int, input().split())
c = int(input())

m += c
t += m//60
print(t%24, m%60)