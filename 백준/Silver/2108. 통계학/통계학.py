import math

n = int(input())
arr = []
dic = {}
sum=0
max=0


for i in range(n):
    arr.append(int(input()))

arr.sort()
length = len(arr)

for i in range(length):
    sum += arr[i]

avg = round(sum/length)
mid = arr[length//2]
ran = arr[length-1] -arr[0]

for i in range(length):
    if arr[i] in dic:
        dic[arr[i]]+=1
    else:
        dic[arr[i]]=1


for i in dic.keys():
    if max < dic[i]:
        max = dic[i]
        maxbin = []
        maxbin.append(i)
    
    elif max == dic[i]:
        maxbin.append(i)

if len(maxbin) != 1:
    maxbin.sort()
    mod = maxbin[1]
else:
    mod = maxbin[0]

print(avg)
print(mid)
print(mod)
print(ran)
