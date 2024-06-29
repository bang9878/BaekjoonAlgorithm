cang=100
sang=100
n = int(input())



    
for i in range(n):
    inputStr = input()
    dice = list(map(int, inputStr.split(' ')))
    
    if(dice[0] > dice[1]):
        sang = sang-dice[0]
    elif(dice[0] < dice[1]):
        cang = cang-dice[1]

print(cang)
print(sang)
