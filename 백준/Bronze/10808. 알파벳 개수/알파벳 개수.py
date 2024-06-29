alpha = [0 for i in range(26)]
s = input()
num = len(s)
for i in range(num):
    s1 = s[i:i+1]
    alpha[ord(s1) - ord('a')]+=1



for i in range(26):
    print(alpha[i],end=' ')
    
