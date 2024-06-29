def main():
    
    while(True):
        num = list(map(int, input()))
        numlen = len(num)
        j=0
        new_num = [0 for i in range(numlen)]
        if num[0] == 0:
            return 0
        
        for i in range((numlen-1), -1, -1):
            new_num[j] = num[i]
            j+=1
        if num==new_num:
            print("yes")
        else:
            print("no")


if __name__ == "__main__":
    main()