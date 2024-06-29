m = int(input())
tel = list(map(int, input().split()))


sumy=0
summ=0

for i in range(m):
    sumy += ((tel[i]//30)+1)*10
    summ += ((tel[i]//60)+1)*15



if sumy == summ:
    print("Y M", sumy)

elif sumy>summ:
    print("M", summ)

elif sumy < summ:
    print("Y", sumy)
