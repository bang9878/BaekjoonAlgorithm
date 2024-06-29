n, k = map(int, input().split())

def factoria(a):
    ans = 1
    for i in range(2,a+1):
        ans*=i
    return ans

def bino(a,b):
    return factoria(a)//factoria(b)//factoria(a-b)

print(bino(n,k))