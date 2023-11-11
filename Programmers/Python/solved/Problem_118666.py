# link : https://school.programmers.co.kr/learn/courses/30/lessons/118666
# title : 성격 유형 검사하기


def solution(survey, choices):
    li = ["R","T","C","F","J","M","A","N","R"]
    mbti = dict(zip(li, [0]*len(li)))
    result = ""
    
    for idx, seq in enumerate(survey):
        if choices[idx] in [1,2,3]:
            mbti[list(seq)[0]] += mapper(choices[idx])
        else:
            mbti[list(seq)[1]] += mapper(choices[idx])
            
    result += "R" if mbti["R"] >= mbti["T"] else "T"
    result += "C" if mbti["C"] >= mbti["F"] else "F"
    result += "J" if mbti["J"] >= mbti["M"] else "M"
    result += "A" if mbti["A"] >= mbti["N"] else "N"
    
    return result

def mapper(n) :
    if n in [1,7]:
        return 3
    elif n in [2,6]:
        return 2
    elif n in [3,5]: 
        return 1
    else :
        return 0
