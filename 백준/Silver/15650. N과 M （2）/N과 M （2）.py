import sys
read = sys.stdin.readline

def dfs():
    if (len(s) == m) and s == sorted(s):
        print(' '.join(map(str,s)))
        return
    for i in range(1, n+1):
        if visited[i]:
            continue
        visited[i] = True
        s.append(i)
        dfs()
        s.pop()
        visited[i] = False

n, m = map(int, read().split())
s = []
visited = [False] * (n+1)
dfs()
