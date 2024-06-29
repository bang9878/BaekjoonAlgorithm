N = int(input())

arr = [[] for _ in range(N)]

for i in range(N):
    age, name = input().split()
    age = int(age)
    arr[i].append(age)
    arr[i].append(name)

for i in range(N):
    arr[i].append(i)


arr=sorted(arr, key = lambda x: (x[0], x[2]))

for i in range(N):
    print(arr[i][0], arr[i][1])