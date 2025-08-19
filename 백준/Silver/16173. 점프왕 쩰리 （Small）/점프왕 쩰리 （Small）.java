import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[][] board;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine().trim());
        board = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        bw.write(dfs(0,0) ? "HaruHaru" : "Hing");
        bw.close();
        
    }
    
    static boolean dfs(int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= N) return false;
        
        if (visited[r][c]) return false;
        
        int dest = board[r][c];
        if (dest == -1) return true;
        if (dest == 0) return false;
        visited[r][c] = true;
            
        return dfs(r+dest, c) || dfs(r, c+dest);
    }
}