n = int(input())
cnt=0
arry = [input() for _ in range(n)]
tmp_arr = []
len_arr = []
arr = []

for value in arry:
    if value not in arr:
        arr.append(value)

for i in range(len(arr)):
    if len(arr[i]) not in len_arr:
        len_arr.append(len(arr[i]))

len_arr.sort()



for i in range(len(len_arr)):
    tmp_arr = []
    for j in range(len(arr)):
        if len(arr[j]) == len_arr[i]:
            tmp_arr.append(arr[j])
    tmp_arr.sort()

    for k in range(len(tmp_arr)):
        print(tmp_arr[k])

