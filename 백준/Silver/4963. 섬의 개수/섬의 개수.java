import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(true){
            StringTokenizer str = new StringTokenizer(br.readLine());
            
            int w = Integer.parseInt(str.nextToken());
            int h = Integer.parseInt(str.nextToken());
            
            if (w == 0 && h == 0) break;
            
            int[][] land = new int[h][w];
            
            for(int i = 0; i < h; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    land[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int countingLand = count(land, w, h);
            
            bw.write(countingLand + "\n");
        }
            bw.close();
    }
    
    private static int count(int[][] land, int w, int h){
        int result = 0;
        boolean[][] visited = new boolean[h][w];
        
        int[] dx = {-1, 0, 1, 0, -1, 1, 1, -1};
        int[] dy = {0, -1, 0, 1, 1, 1, -1, -1};
        
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(!visited[i][j] && land[i][j] == 1){
                    dfs(land, visited, i, j, w, h, dx, dy);
                    result++;
                }
            }
        }
        return result;
    }
    
    private static void dfs(int[][] land,boolean[][] visited, int x, int y, int w, int h, int[] dx, int[] dy){
        visited[x][y] = true;
        
        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && nx < h && ny >= 0 && ny < w && !visited[nx][ny] && land[nx][ny] == 1){
                dfs(land, visited, nx, ny, w, h, dx, dy);
            }
        }
    }
}