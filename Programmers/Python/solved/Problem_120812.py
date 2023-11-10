# link : https://school.programmers.co.kr/learn/courses/30/lessons/120812
# title : 최빈값 구하기
def solution(array):
    dic = {}
    for i in array :
        if i in dic :
            dic[i] += 1
        else :
            dic[i] = 1
    max_count = 0
    max_values = []
    for k, v in dic.items() :
        if max_count < v :
            max_count = v
            max_values.clear()
            max_values.append(k)
        elif max_count == v :
            max_values.append(k)
    return max_values[0] if len(max_values) == 1 else -1