mes = input()
if mes == ' ':
    print("0")
else:
    mes = mes.strip()
    cnt = mes.count(' ')
    print(cnt+1)   