import java.io.*;
import java.util.*;

public class Main {
    static char[][] alphabets;
    static int R, C;
    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");

        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        alphabets = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            alphabets[i] = line.toCharArray();
        }

        Set<Character> visited = new HashSet<>();
        visited.add(alphabets[0][0]); 
        dfs(0, 0, visited, 1);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    private static void dfs(int x, int y, Set<Character> visited, int length) {
        answer = Math.max(answer, length); 

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visited.contains(alphabets[nx][ny])) {
                visited.add(alphabets[nx][ny]); 
                dfs(nx, ny, visited, length + 1); 
                visited.remove(alphabets[nx][ny]);
            }
        }
    }
}
