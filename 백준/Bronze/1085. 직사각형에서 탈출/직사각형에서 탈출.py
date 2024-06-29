from cmath import sqrt


x, y, w, h = map(int, input().split())
a = [0 for i in range(4)]
case1 = w-x
case2 = h-y

a[0] = case1
a[1] = case2
a[2] = x
a[3] = y

print(min(a))