n, m = map(int, input().split())
cnt=0
ind=0
mini=[10000 for _ in range(5002)]
board = [list(input()) for _ in range(n)]



case1 = [["B","W","B","W","B","W","B","W"], ["W","B","W","B","W","B","W","B"],
        ["B","W","B","W","B","W","B","W"], ["W","B","W","B","W","B","W","B"],
        ["B","W","B","W","B","W","B","W"], ["W","B","W","B","W","B","W","B"],
        ["B","W","B","W","B","W","B","W"], ["W","B","W","B","W","B","W","B"],]

case2 = [["W","B","W","B","W","B","W","B"], ["B","W","B","W","B","W","B","W"],
        ["W","B","W","B","W","B","W","B"], ["B","W","B","W","B","W","B","W"],
        ["W","B","W","B","W","B","W","B"], ["B","W","B","W","B","W","B","W"],
        ["W","B","W","B","W","B","W","B"], ["B","W","B","W","B","W","B","W"],]


def gett1(r,c):
    global board
    global cnt
    global mini
    global ind
    global n, m
    
    x=0
    y=0

    if r >= n-7 or c >= m-7:
        return
    for i in range(r,r+8):
        for j in range(c,c+8):
            if board[i][j] != case1[x][y] and (x<8 or y<8):
                cnt+=1
            y+=1
        y=0
        x+=1
    
    mini[ind] =cnt
    ind+=1
    cnt=0
    x=0
    y=0


def gett2(r,c):
    global ind
    global mini
    global cnt
    global n, m
    global board
    x1=0
    y1=0

    if r >= n-7 or c >= m-7:
        return

    for i in range(r,r+8):
        for j in range(c,c+8):
            if board[i][j] !=case2[x1][y1] and (x1<8 or y1<8):
                cnt+=1
            y1+=1
        y1=0
        x1+=1
    
    mini[ind] =cnt
    ind+=1
    cnt=0
    x1=0
    y1=0
    

for i in range(n):
    for j in range(m):
        gett1(i,j)
        gett2(i,j)


print(min(mini))
