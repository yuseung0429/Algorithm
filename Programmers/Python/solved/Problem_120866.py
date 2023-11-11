# link : https://school.programmers.co.kr/learn/courses/30/lessons/120866
# title : 안전지대

def solution(board):
    n = len(board)

    arr = [[0 for j in range(n)] for i in range(n)]
    
    for i in range(n):
        for j in range(n):
            if board[i][j] == 1:
                arr = mark(board, arr, i, j)
    
    cnt = 0
    for i in range(n):
        for j in range(n):
            if arr[i][j] == 0:
                cnt += 1
    return cnt

def mark(board, result, idx_r, idx_c):
    n = len(board)
    for i in range(-1,2,1):
        for j in range(-1,2,1):
            if((idx_r+i >= 0) & (idx_r+i < n) & (idx_c+j >= 0) & (idx_c+j < n)) :
                result[idx_r+i][idx_c+j] = 1
    return result

board = [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]]
print(solution(board))