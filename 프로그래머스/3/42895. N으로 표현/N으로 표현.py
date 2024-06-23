def solution(N, number):
#     n이 number면 1 리턴
    if N == number:
        return 1
    
#       1개부터 8개로 만들 수 있는 값을 체크, number가 나오면 리턴.    
#       N을 개수만큼 채워둠
    dp = [set() for _ in range(9)]
    for i in range(1, 9):
        dp[i].add(int(str(N) * i))
        
#         나올 수 있는 경우의 수를 모두 만듦. 
    for i in range(1, 9):   # N을 i번 사용 
        for j in range(1, i):    
            for x in dp[j]:
                for y in dp[i - j]:    # i 랑 [i-j] 의 결과를 합침 => 모든 경우의 수. 
                    dp[i].add(x + y)
                    dp[i].add(x - y)
                    dp[i].add(x * y)
                    if y != 0:
                        dp[i].add(x // y)
        if number in dp[i]:
            return i
    
    return -1
