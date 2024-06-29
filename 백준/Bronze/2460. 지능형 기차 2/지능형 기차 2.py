train = [[0 for row in range(2)] for col in range(10)]
sum = [0 for i in range(10)]

for i in range(10):
    inputStr = input()
    train[i] = list(map(int, inputStr.split(' ')))
    for j in range(2):
        if i>0:
            sum[i] = train[i][1] - train[i][0] + sum[i-1]
        else:
            sum[i] = train[i][1] - train[i][0]


max=0

for i in range(10):
    if sum[i]>max:
        max=sum[i]

print(max)
        
