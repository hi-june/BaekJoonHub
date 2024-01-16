from itertools import combinations

def solution(nums):
    c = combinations(nums, 3)
    count = 0
    
    for i in c:
        if is_prime(sum(i)):
            count += 1
    
    return count

def is_prime(n):
    for i in range(2, n):
        if n % i == 0:
            return False
    
    return True