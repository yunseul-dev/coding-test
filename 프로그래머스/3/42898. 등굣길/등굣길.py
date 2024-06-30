def solution(m, n, puddles):
    puddles = [[j,i] for [i,j] in puddles]      # [x,y] -> [y,x]
    dp = [[0] * (m + 1) for _ in range(n + 1)] 
    dp[1][1] = 1           # start

    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if i == 1 and j == 1: continue 
            if [i, j] in puddles:    # 웅덩이 = 0
                dp[i][j] = 0
            else:                    # 현재 칸은 왼쪽에서 오는거 + 위에서 오는거 
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007
                
                
    return dp[n][m]