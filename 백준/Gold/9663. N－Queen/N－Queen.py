import sys
myinput = sys.stdin.readline

N = int(myinput())
answer = 0

# 각 열, 두 대각선에 퀸이 있는지 여부를 저장하는 배열
col = [False] * N
diag1 = [False] * (2 * N - 1)  # 좌상향 대각선
diag2 = [False] * (2 * N - 1)  # 우상향 대각선

def finding(row):
    global answer
    if row == N:  # 모든 행에 퀸을 배치한 경우
        answer += 1
        return
    
    for i in range(N):
        if not col[i] and not diag1[row + i] and not diag2[row - i + N - 1]:
            # 퀸을 놓을 수 있으면 체크하고 진행
            col[i] = diag1[row + i] = diag2[row - i + N - 1] = True
            finding(row + 1)
            # 백트래킹: 퀸을 다시 놓지 않도록 체크 해제
            col[i] = diag1[row + i] = diag2[row - i + N - 1] = False

finding(0)
print(answer)
