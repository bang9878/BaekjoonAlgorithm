t = int(input())
for i in range(t):
    total=0
    cnt=0
    in_str  = input()
    for j in range(len(in_str)):
        if in_str[j] == 'O':
            cnt+=1
            total+=cnt
        else:
            cnt=0
            
                  
    print(total)
