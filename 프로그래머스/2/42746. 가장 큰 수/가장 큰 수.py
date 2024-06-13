def solution(numbers):
    if all(num == 0 for num in numbers): return '0'
    return ''.join(sorted(map(str, numbers), key=lambda x: x*3, reverse=True))
    
