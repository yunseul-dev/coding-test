import java.io.*;
import java.util.*;

public class Main {
    static int[] graph; 
    static boolean[] visited; 
    static boolean[] finished; 
    static int count; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); 

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine()); 
            graph = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            bw.write((n - count) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int current) {
        visited[current] = true;
        int next = graph[current];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            count++;
            for (int i = next; i != current; i = graph[i]) {
                count++;
            }
        }

        finished[current] = true;
    }
}
