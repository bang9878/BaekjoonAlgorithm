T = int(input())
apart = [[0]*15 for _ in range(15)]


for i in range(15):
    apart[0][i] = i

for i in range(1,15):   
    for j in range(1,15):
        for p in range(1,j+1):
            apart[i][j] += apart[i-1][p]



for a in range(T):
    k = int(input())
    n = int(input())
    print(apart[k][n])


        