import java.io.*;
import java.util.*;

public class Main {
    static int[] colors;
    static List<Integer>[] graph;
    static boolean isValid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());

        for (int t = 0; t < K; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];
            colors = new int[V + 1];
            Arrays.fill(colors, -1);

            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }

            isValid = true;
            for (int i = 1; i <= V; i++) {
                if (colors[i] == -1) {
                    if (!bfs(i)) {
                        isValid = false;
                        break;
                    }
                }
            }

            bw.write(isValid ? "YES\n" : "NO\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (colors[neighbor] == -1) {
                    colors[neighbor] = 1 - colors[node];
                    queue.add(neighbor);
                } else if (colors[neighbor] == colors[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}
