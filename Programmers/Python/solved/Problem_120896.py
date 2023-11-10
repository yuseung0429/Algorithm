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


print(solution("abcdasdasd"))
