import sys
#sys.stdin = open("input.txt","r")
n, m, b = map(int, sys.stdin.readline().split())

max=0
ground = [[]for _ in range(n)]
tmp=b
mint = 128000001
height = 0

for i in range(n):
    ground[i] = list(map(int, sys.stdin.readline().split()))

time=0
flag=0
for k in range(256,-1,-1):
    time=0
    tmp=b
    flag=0
    for i in ground:
        for j in i:
            if j>k:
                tmp += j - k
                time += (j - k)*2
    
    for i in ground:
        if flag == 1:
            break
        for j in i:
            if j<k:
                tmp -= (k - j)
                time += k - j
                if tmp<0:
                    flag=1
                    time=128000001
                    break
                
    if mint > time:
        mint = time
        height = k

print(mint, height)
