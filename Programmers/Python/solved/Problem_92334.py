# link : https://school.programmers.co.kr/learn/courses/30/lessons/92334
# title : 신고 결과 받기
def solution(id_list, report, limit):
    s = set(report)

    temp = []    
    for _ in range(0, len(id_list)) :
        temp.append([])
        
    report_count = dict(zip(id_list, [0]*len(id_list))) 
    reporter = dict(zip(id_list, temp))

    for i in s :
        a = i.split(" ")[0]
        b = i.split(" ")[1]
        report_count[b] += 1
        reporter[b].append(a)

    ban_list = []
    result = [0] * len(id_list)
    
    for k, v in report_count.items():
        if v >= limit:
            ban_list.append(k)
                 
    for k, v in reporter.items(): 
        if k in ban_list:
            for a in v:
                result[id_list.index(a)] += 1

    return result
            