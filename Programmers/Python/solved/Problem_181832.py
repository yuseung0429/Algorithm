# link : https://school.programmers.co.kr/learn/courses/30/lessons/181832
# title : 정수를 나선형으로 배치하기

def solution(n):
    arr = [[n*n+1 for j in range(n)] for i in range(n)]
    state = 0
    idx_r = 0
    idx_c = 0
    for i in range(1, n*n+1) :
        idx_r, idx_c, state = insert(arr, i, idx_r, idx_c, state)
    return arr

def insert(arr, i, idx_r, idx_c, state):
    if idx_r < 0 or idx_r >= len(arr) or idx_c < 0 or idx_c >= len(arr) or (arr[idx_r][idx_c] < i):
        state = (state + 1)%4
        if state == 0 :
            idx_r +=1
            idx_c +=1
        elif state == 1:
            idx_r +=1
            idx_c -=1
        elif state == 2:
            idx_r -=1
            idx_c -=1
        else :
            idx_r -=1
            idx_c +=1

    arr[idx_r][idx_c] = i

    if state == 0 :
        idx_c += 1
    elif state == 1:
        idx_r += 1
    elif state == 2:
        idx_c -= 1
    else :
        idx_r -= 1

    return idx_r, idx_c, state
