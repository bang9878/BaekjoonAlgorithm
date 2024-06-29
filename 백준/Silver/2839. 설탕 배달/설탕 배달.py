N = int(input())
mini = []
arr5 = [i for i in range(0,N+1,5)]
arr3 = [i for i in range(0,N+1,3)]


for i in range(len(arr3)):
    for j in range(len(arr5)):
        if arr3[i] + arr5[j] == N:
            mini.append((i) + (j))
            

if len(mini) == 0:
    print("-1")

else:
    print(min(mini))