n, m = map(int, input().split())

card = list(map(int, input().split()))
mini = []
card.sort(reverse=True)

flag=1
min=300000
tmp=0
for i in range(0,n):
    for j in range(i+1, n):
        for k in range(j+1,n):
            blackjack = card[i] + card[j] + card[k]
            if blackjack <= m and flag == 1:
                flag=0
                tmp = blackjack
            if tmp< blackjack and blackjack <= m:
                tmp = blackjack
print(tmp)



          

