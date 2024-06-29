d1, d2, d3 = map(int, input().split())
total = [0 for _ in range(81)]
sum=0

for i in range(1,d1+1):
    for j in range(1,d2+1):
        for k in range(1,d3+1):
            sum = i+j+k
            total[sum]+=1

maxx = max(total)


for i in range(81):
    if total[i] == maxx:
        print(i)
        break


