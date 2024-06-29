num = int(input())
cnt=0
j=0
def factorial(n):
    ans = 1
    for i in range(2,n+1):
        ans *= i
    return ans

fac = list(map(int,str(factorial(num))))

for i in range(len(fac)-1, -1, -1):
    if fac[i]==0 and j==cnt:
        cnt+=1
    j+=1

if fac[len(fac)-1] != 0:
    print("0")
else:
    print(cnt)