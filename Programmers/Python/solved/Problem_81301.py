# link : https://school.programmers.co.kr/learn/courses/30/lessons/81301
# title : 숫자 문자열과 영단어
def solution(s):
    list = ["zero", "one", "two", "three", "four", 
            "five", "six", "seven", "eight", "nine"]
    
    for idx, i in enumerate(list) :
        s = s.replace(i, str(idx))
                      
    return int(s)
