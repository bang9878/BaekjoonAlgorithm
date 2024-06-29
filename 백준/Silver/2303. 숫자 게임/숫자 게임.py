N = int(input())
arr= [list(map(int, input().split())) for i in range(N)]
res =[]
for i in range(N):
    maxx=0
    for j in range(3):
        for k in range(j+1,5):
            for h in range(k+1,5):
                big = (arr[i][j]+arr[i][k]+arr[i][h]) %10
                if maxx<big:
                    maxx=big
    res.append(maxx)


for i in range(len(res)-1,-1,-1):
    if max(res) == res[i]:
        print(i+1)
        break
