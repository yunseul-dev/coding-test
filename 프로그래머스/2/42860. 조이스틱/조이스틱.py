def solution(name):
    updown = 0
    cursor = len(name) - 1  
    
    
    for i, char in enumerate(name):
        updown += min(ord(char) - ord('A'), 26 - (ord(char) - ord('A')))
        
        next = i + 1 # 다음 위치
        while next < len(name) and name[next] == 'A': # 다음 글자가 A면 지나가기
            next += 1
            
        # 좌우 이동을 최소화하는 방법 계산
        # 1. 처음부터 끝까지 가는 방법
        # 2. 현재 위치에서 다시 처음으로 돌아가서 'A'가 아닌 다음 문자로 가는 방법
        # 3. 현재 위치에서 끝까지 가서 'A'가 아닌 문자로 돌아오는 방법
        print('i ', i ,'next', next)
        print([ cursor, 2 * i + len(name) - next, i + 2 * (len(name) - next) ])
        cursor = min([ cursor, 2 * i + len(name) - next, i + 2 * (len(name) - next) ])
        
    return updown + cursor