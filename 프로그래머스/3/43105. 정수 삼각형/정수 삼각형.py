def solution(triangle):    
    for i in range(1, len(triangle)):
        for j in range(i+1):
            if (j==0):   # 제일 왼쪽 값이면, 바로 위 더하기 (시작점)
                triangle[i][j] += triangle[i-1][j]
            elif (j==i):  # 제일 오른쪽이면, 바로 위에서 왼쪽 (한개 더 작음)
                triangle[i][j] += triangle[i-1][j-1]
            else:  # 가운데면 둘 중에 더 큰 값
                triangle[i][j] += max(triangle[i-1][j], triangle[i-1][j-1])
                
    return max(triangle[len(triangle)-1])