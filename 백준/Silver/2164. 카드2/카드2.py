import sys
from collections import deque

card = deque()

N = int(sys.stdin.readline())

for i in range(1,N+1):
    card.appendleft(i)


while(True):
    if len(card) == 1:
        break
    card.pop()
    card.appendleft(card.pop())


print(card.pop())
