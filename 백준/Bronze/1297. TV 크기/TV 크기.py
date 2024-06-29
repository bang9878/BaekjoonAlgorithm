import math

D, H, W = map(int, input().split())

ratio = D*D/(H*H + W*W)
ratio = math.sqrt(ratio)

H = math.trunc(H*ratio)
W = math.trunc(W*ratio)

print(H,W)