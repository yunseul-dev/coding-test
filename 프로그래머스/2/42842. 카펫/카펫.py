import math

def solution(brown, yellow):
    total = brown + yellow
    
    for width in range(3, int(math.sqrt(total)) + 1):  
        if total % width == 0:
            height = total / width
            if yellow == (width - 2) * (height - 2):   
                return [height, width]