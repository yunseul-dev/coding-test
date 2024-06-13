def solution(word):
    words = ['A', 'E', 'I', 'O', 'U']
    weights = [781, 156, 31, 6, 1] 
    
    answer = 0
    for i, char in enumerate(word):
        index = words.index(char)
        answer += (index  * weights[i]) + 1
    
    return answer
