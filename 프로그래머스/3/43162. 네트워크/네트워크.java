class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n]; 

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                this.dfs(i, n, visited, computers);
                answer++;
            }
        }

        return answer;
    }

    public void dfs(int i , int n, boolean[] visited, int[][] computers){
        visited[i] = true;
        for(int j = 0; j < n; j++){
            if(computers[i][j] == 1 && !visited[j] ){
                dfs(j, n, visited,computers);
            }
        }
    }
}