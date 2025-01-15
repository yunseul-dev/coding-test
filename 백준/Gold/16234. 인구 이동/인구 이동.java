import java.io.*;
import java.util.*;

public class Main{
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int cnt = 0;
        
        while(true){
            visited = new boolean[N][N];
            boolean open = false;
            
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j]){
                        if(bfs(i,j)){
                            open = true;
                        }
                    }
                }
            }
            
            if(!open){
                break;
            }
            cnt++;
        }
        
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
    
    static boolean bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> union = new ArrayList<>();
        queue.offer(new int[]{x,y});
        union.add(new int[]{x,y});
        visited[x][y] = true;
        
        int sum = map[x][y];
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];
            
            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]){
                    int diff = Math.abs(map[cx][cy] - map[nx][ny]);
                    if(diff >= L && diff <= R){
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        union.add(new int[]{nx, ny});
                        sum += map[nx][ny];
                    }
                }
            }
        }
        
        if(union.size() > 1){
            int newPeople = sum / union.size();
            for(int[] u: union){
                map[u[0]][u[1]] = newPeople;
            }
            
            return true;
        }
        return false;
    }
}