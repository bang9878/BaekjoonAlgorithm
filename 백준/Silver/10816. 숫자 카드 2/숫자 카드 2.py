card = {}

N = int(input())
arr = list(map(int,input().split()))

M = int(input())
arr1 = list(map(int,input().split()))

for i in range(len(arr)):
    if arr[i] in card:
        card[arr[i]]+=1
    else:
        card[arr[i]]=1

for i in range(len(arr1)):
    if arr1[i] in card:
        print(str(card[arr1[i]])+' ',end='')
    
    else:
        print("0 ",end='')