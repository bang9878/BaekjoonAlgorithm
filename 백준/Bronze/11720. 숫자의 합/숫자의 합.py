n = int(input())
a = [0 for i in range(n)]

a = list(map(int,input()))

sum=0
for j in range(n):
    sum+=a[j]

print(sum)