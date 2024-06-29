N = int(input())

arr = [[] for _ in range(N)]

for i in range(N):
    x, y = map(int, input().split())
    arr[i].append(x)
    arr[i].append(y)

arr = sorted(arr, key = lambda x: (x[0], x[1]))

for i in range(N):
    print(arr[i][0], arr[i][1])