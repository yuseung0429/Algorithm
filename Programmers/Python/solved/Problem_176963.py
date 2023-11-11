# link : https://school.programmers.co.kr/learn/courses/30/lessons/176963
# title : 추억 점수
def solution(name, yearning, photo):
    dic = {}
    li = []
    for i, v in enumerate(name) :
        dic[v] = yearning[i]
    for i in photo :
        sum = 0
        for j in i :
            sum += (dic[j] if (j in dic) else 0)
        li.append(sum)
    return li