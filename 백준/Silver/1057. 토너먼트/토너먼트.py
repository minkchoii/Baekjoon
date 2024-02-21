import math
import sys

n, kim, lim = map(int, sys.stdin.readline().split())
cnt = 0
while True:
    if math.ceil(kim)==math.ceil(lim):
        break
        
    kim = math.ceil(kim/2)
    lim = math.ceil(lim/2)
    cnt+=1
    
print(cnt)