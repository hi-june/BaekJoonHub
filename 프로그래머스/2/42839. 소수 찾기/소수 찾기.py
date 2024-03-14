from itertools import permutations
from math import sqrt

def solution(numbers):
    nums = list(numbers)
    prime_set = set()
    
    for i in range(1, len(nums) + 1):
        t = permutations(nums, i)
        
        for j in t:
            num = int("".join(j))
            
            if (is_prime(num)):
                prime_set.add(num)
    
    return len(prime_set)
    
def is_prime(n):
    if n == 1 or n == 0: 
        return False
    
    if n == 2:
        return True
    
    for i in range(2, int(sqrt(n)) + 1):
        if n % i == 0:
            return False
    
    return True