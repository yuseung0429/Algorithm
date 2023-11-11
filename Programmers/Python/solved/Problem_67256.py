# link : https://school.programmers.co.kr/learn/courses/30/lessons/67256
# title : [카카오 인턴] 키패드 누르기

def distance(number, pos):
    if number == 2 :
        for idx, distance in enumerate([[2],[1,3,5],[4,6,8],[7,9,0],[-1]]) :
            if pos in distance :
                return idx
    elif number == 5 :
        for idx, distance in enumerate([[5],[2,4,6,8],[1,3,7,9,0],[-1]]) :
            if pos in distance :
                return idx
    elif number == 8 :
        for idx, distance in enumerate([[8],[5,7,9,0],[4,6,-1,2],[1,3]]) :
            if pos in distance :
                return idx
    else :
        for idx, distance in enumerate([[0],[-1,8],[5,7,9],[2,4,6],[1,3]]) :
            if pos in distance :
                return idx
            
def solution(numbers, hand):
    result = ""
    left_pos = -1
    right_pos = -1
    for i in numbers :
        print((left_pos, right_pos))
        if i in [1,4,7]:
            result += "L"
            left_pos = i
        elif i in [3,6,9]:
            result += "R"
            right_pos = i;            
        else :
            if(distance(i,left_pos) == distance(i,right_pos)) :
                if hand == "right" :
                    result += "R"
                    right_pos = i
                else :
                    result += "L"
                    left_pos = i
            elif(distance(i,left_pos) > distance(i,right_pos)) :
                result += "R"
                right_pos = i
            else :
                result += "L"
                left_pos = i
    return result