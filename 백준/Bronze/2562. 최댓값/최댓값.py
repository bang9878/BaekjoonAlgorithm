max=0

for i in range(9):
    num = int(input())
    if num > max:
        max = num
        index = i
print(max)
print(index+1)