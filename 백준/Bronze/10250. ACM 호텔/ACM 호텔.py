t = int(input())

for i in range(t):
    w,h,n = map(int, input().split())
    
    if n%w==0:
        r = n//w
        room = w*100+r
        print(room)    
    
    else:
        f = n%w
        r = n//w
        room = f*100+(r+1)
        print(room)    