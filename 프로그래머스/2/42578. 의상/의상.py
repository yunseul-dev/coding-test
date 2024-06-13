from collections import Counter

def solution(clothes):
    answer = 1
    category_counts = Counter(clothe[1] for clothe in clothes) #인덱스 1을 key로 
    
    for count in category_counts.values():
        answer *= (count + 1) 
    
    return answer - 1  # 아무것도 안입는 경우 제외