# link : https://school.programmers.co.kr/learn/courses/30/lessons/160586
# title : 대충 만든 자판

def solution(keymap, targets):
    result = []   
    li = []
    for target in targets :
        sum = 0
        if check(keymap, target) :
            for token in target :
                for key in keymap :
                    idx = key.find(token)
                    li.append( (idx+1) if idx!=-1 else 101)
                sum += min(li)
                li.clear()
        else :
            result.append(-1)
            continue
        result.append(sum)
    return result

def check(keymap, target) :
    str = ""
    for i in keymap:
        str = str + i;
    s1 = set(list(str))
    s2 = set(list(target))
    return s2.issubset(s1)