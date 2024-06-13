def dfs(graph, start, visited):
    count = 1 
    visited[start] = True  
    
    for i in graph[start]:  
        if not visited[i]:  
            count += dfs(graph, i, visited)  
    return count

def solution(n, wires):
    answer = n
    graph = [[] for _ in range(n+1)]
    
    print(graph)
    
    # 그래프 구성
    for v1, v2 in wires:
        graph[v1].append(v2)
        graph[v2].append(v1)
    
    for v1, v2 in wires:
        visited = [False] * (n+1)
        
        graph[v1].remove(v2) # 하나 끊기 
        graph[v2].remove(v1)
        
        count = dfs(graph, v1, visited)
        answer = min(answer, abs(count - (n - count)))
        
        graph[v1].append(v2)
        graph[v2].append(v1)
        
    return answer
