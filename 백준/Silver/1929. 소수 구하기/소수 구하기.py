import sys

M, N = map(int, sys.stdin.readline().split())

decimal = [-1 for _ in range(1000001)]

for i in range(M,N+1):
    decimal[i] = i


for i in range(2,N+1,1):
    if(decimal[i]==0):continue

    for j in range(2*i, N+1, i):
        decimal[j]=0

for i in range(M,N+1):
    if decimal[i] != 0 and  decimal[i] != -1 and decimal[i] != 1: print(decimal[i])