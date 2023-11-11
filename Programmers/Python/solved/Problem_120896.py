
# link : https://school.programmers.co.kr/learn/courses/30/lessons/120896
# title : 한 번만 등장한 문자

def solution(s):
    dic = {}
    list = []
    for i in s :
        if i in dic:
            dic[i] += 1
        else :
            dic[i] = 1
    for k, v in dic.items() :
        if v == 1 :
            list.append(k)
    list.sort()
    return "".join(list)