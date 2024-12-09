import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    private static int n; 
    private static char[][] grid;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    
    private static void dfs(int x, int y, char color){
        visited[x][y] = true;
        
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && ny >= 0 && nx < n && ny < n) { 
                if(!visited[nx][ny] && grid[nx][ny] == color) { 
                    dfs(nx, ny, color);
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        grid = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }
        
        visited = new boolean[n][n];
        int notJR = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    dfs(i, j, grid[i][j]);
                    notJR++;
                }
            }
        }
        
        // 적록색약 배열 수정
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'G') {
                    grid[i][j] = 'R';
                }
            }
        }
        
        visited = new boolean[n][n];
        int yesJR = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    dfs(i, j, grid[i][j]);
                    yesJR++;
                }
            }
        }
        
        bw.write(notJR + " " + yesJR);
        bw.flush();
    }
}
