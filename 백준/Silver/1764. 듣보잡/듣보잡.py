n, m = map(int, input().split())
cnt=0
arr = []
new_arr = []
for i in range(n+m):
    arr.append(input())

shj ={}

for i in arr:
    try:
        shj[i]+=1
    except:
        shj[i]=1

for i in shj.keys():
    if shj[i] >= 2:
        cnt+=1
        new_arr.append(i)

print(cnt)
new_arr.sort()
for i in range(len(new_arr)):
    print(new_arr[i])
