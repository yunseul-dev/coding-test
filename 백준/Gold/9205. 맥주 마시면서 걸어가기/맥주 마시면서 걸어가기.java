import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int[][] points = new int[n + 2][2]; 
            
            st = new StringTokenizer(br.readLine());
            points[0][0] = Integer.parseInt(st.nextToken());
            points[0][1] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            points[n + 1][0] = Integer.parseInt(st.nextToken());
            points[n + 1][1] = Integer.parseInt(st.nextToken());

            boolean canReach = bfs(points, n);
            bw.write(canReach ? "happy\n" : "sad\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean bfs(int[][] points, int n) {
        boolean[] visited = new boolean[n + 2];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0); 
        visited[0] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == n + 1) return true;

            for (int i = 0; i < points.length; i++) {
                if (!visited[i]) {
                    int dist = Math.abs(points[now][0] - points[i][0]) + Math.abs(points[now][1] - points[i][1]);

                    if (dist <= 1000) { 
                        visited[i] = true;
                        queue.offer(i);
                    }
                }
            }
        }

        return false; 
    }
}
