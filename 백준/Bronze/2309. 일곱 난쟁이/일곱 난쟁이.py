small = [0 for i in range(9)]
total = 0
naljiBreak = True
for i in range(9):
    small[i] = int(input())
    total += small[i]
real = total - 100


for i in range(9):
    for j in range(i+1, 9):
        if(small[i] + small[j] == real):
            
            del small[i]
            del small[j-1]
            naljiBreak = False
            break
    if(naljiBreak == False):
        break
small.sort()

for i in range(7):
    print(small[i])

