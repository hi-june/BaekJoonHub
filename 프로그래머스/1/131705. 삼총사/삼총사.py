from itertools import combinations

def solution(number):
    c = combinations(number, 3)
    count = 0
    
    for i in c:
        if sum(i) == 0:
            count += 1
    
    return count