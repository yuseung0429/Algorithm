# link : https://school.programmers.co.kr/learn/courses/30/lessons/120888
# title : 중복된 문자 제거

def solution(my_string):
    li = []
    for i in my_string:
        if(i not in li):
            li.append(i)
    return "".join(li)

print(solution("people"))
print(solution("We are the world"))