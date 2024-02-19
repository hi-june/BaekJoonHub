def solution(dartResult):
    l1 = ['0','1','2','3','4','5','6','7','8','9']
    l2 = ['S','D','T']
    l3 = ['*','#']
    
    lresult = []
    i = 0
    
    while i < len(dartResult):
        if dartResult[i] in l1: # 숫자인 경우
            if dartResult[i:i+2] == "10":
                lresult.append(10)
                i += 2
            else:
                lresult.append(int(dartResult[i]))
                i += 1
        elif dartResult[i] in l2:   # 점수인 경우
            if dartResult[i] == 'S':
                lresult[-1] = lresult[-1] ** 1
            elif dartResult[i] == 'D':
                lresult[-1] = lresult[-1] ** 2
            elif dartResult[i] == 'T':
                lresult[-1] = lresult[-1] ** 3
            i += 1
        elif dartResult[i] in l3:   # 보너스인 경우
            if dartResult[i] == '*':
                if len(lresult) > 1:
                    lresult[-1] = lresult[-1] * 2
                    lresult[-2] = lresult[-2] * 2
                else:
                    lresult[-1] = lresult[-1] * 2
            elif dartResult[i] == '#':
                lresult[-1] = lresult[-1] * -1
            i += 1
    
    return sum(lresult)