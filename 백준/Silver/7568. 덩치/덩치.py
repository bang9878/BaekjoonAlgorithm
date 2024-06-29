def compare(a,b):
    return a[0] < b[0] and a[1] < b[1]


N = int(input())
big = [list(map(int, input().split())) for _ in range(N)]
order = [1 for _ in range(N)]


ranking = 1
for i in range(N):
    for j in range(N):
        if compare(big[i], big[j]):
            order[i]+=1

for i in range(N):
    print(order[i], end=' ')



