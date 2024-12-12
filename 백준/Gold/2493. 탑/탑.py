import sys

N = int(sys.stdin.readline())
data = list(map(int, sys.stdin.readline().split()))

stack = []
result = [0] * N

for i in range(0, N):
    while stack and data[stack[-1]] < data[i]:
        stack.pop()
    if not stack:
        stack.append(i)
    else:
        result[i] = stack[-1]+1
        stack.append(i)

print(*result)