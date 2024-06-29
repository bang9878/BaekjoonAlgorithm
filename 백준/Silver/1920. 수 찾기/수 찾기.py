import sys

n = int(sys.stdin.readline())
arr_n = [0 for _ in range(n)]

arr_n = set(map(int, sys.stdin.readline().split()))

m = int(sys.stdin.readline())
arr_m = [0 for _ in range(m)]
arr_m = list(map(int, sys.stdin.readline().split()))

fact = [0 for _ in range(m)]

for i in range(m):
    if arr_m[i] in arr_n:
        print("1")
    else:
        print("0")