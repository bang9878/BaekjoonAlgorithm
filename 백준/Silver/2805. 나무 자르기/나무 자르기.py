n, m = map(int, input().split())
tree = list(map(int, input().split()))
maxlen = []

tree.sort(reverse=True)

left = 0
right = tree[0]+1
treesum=0
while left+1<right:
    mid = (left+right)//2
    treesum = 0
    for i in range(len(tree)):
        if tree[i] <= mid:
            continue
        num = tree[i] - mid
        treesum += num
    if treesum >= m:
        maxlen.append(mid)
        left = mid
    elif treesum < m:
        right = mid
if len(maxlen) == 0:
    print("0")
else:
    print(max(maxlen))
