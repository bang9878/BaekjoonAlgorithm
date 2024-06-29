n = int(input())

digit=0
min_num = []
for i in range(1,n):
    arr = list(map(int, str(i)))
    for j in range(len(arr)):
        digit += arr[j]
    if n == i+digit:
        min_num.append(i)
    arr = []
    digit=0

if len(min_num) == 0:
    print("0")
else:
    print(min(min_num))