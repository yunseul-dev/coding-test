import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main{    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][m];
        Queue<int[]> queue = new LinkedList<>(); 
        
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()); 
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken()); 
                if(grid[i][j] == 1){ 
                    queue.offer(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] now = queue.poll();
                int x = now[0];
                int y = now[1];
                
                for(int j = 0; j < 4; j++){
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    
                    if(nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == 0){
                        grid[nx][ny] = 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            
            answer++;  
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){  
                    bw.write("-1");
                    bw.flush();
                    return;
                }
            }
        }

        bw.write(String.valueOf(answer - 1));
        bw.flush();
    }
}
