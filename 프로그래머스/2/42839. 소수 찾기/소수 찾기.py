from itertools import permutations
import math

def is_sosu(n):
    if n < 2:   
        return False
    for i in range(2, int(math.sqrt(n)) + 1):  
        if n % i == 0:
            return False
    return True

def solution(numbers):
    answer = 0
    perms = set()  # 중복 제거를 위해서 set 이용
    for i in range(1, len(numbers) + 1):
        perms.update([int(''.join(p)) for p in permutations(numbers,i)])  # 모든 조합
    
    for num in perms:
        if is_sosu(int(num)):  # 소수인지 확인
            answer += 1
    
    return answer
