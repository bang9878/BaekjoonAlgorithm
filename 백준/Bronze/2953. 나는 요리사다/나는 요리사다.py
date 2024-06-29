cook=[[0 for col in range(4)] for row in range(5)]
sum = [0 for add in range(5)]

max=0
num=0

for i in range(5):
    inputstr = input()
    cook[i] = list(map(int,inputstr.split(' ')))
    for j in range(4):
        sum[i] += cook[i][j]

for i in range(5):
    if(sum[i]>max):
        max=sum[i]
        num=i+1

print(num, max)
