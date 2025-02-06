import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); 
        int V = Integer.parseInt(st.nextToken()); 

        HashMap<Integer, PriorityQueue<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            graph.put(i, new PriorityQueue<>()); 
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visitedDFS = new boolean[N + 1]; 
        StringBuilder dfsResult = new StringBuilder();
        dfs(graph, V, visitedDFS, dfsResult);
        bw.write(dfsResult.toString().trim() + "\n");

        boolean[] visitedBFS = new boolean[N + 1]; 
        StringBuilder bfsResult = bfs(graph, V, visitedBFS);
        bw.write(bfsResult.toString().trim() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(HashMap<Integer, PriorityQueue<Integer>> graph, int node, boolean[] visited, StringBuilder result) {
        if (visited[node]) return;

        visited[node] = true;
        result.append(node).append(" ");

        PriorityQueue<Integer> pq = new PriorityQueue<>(graph.get(node));
        while (!pq.isEmpty()) {
            int next = pq.poll();
            dfs(graph, next, visited, result);
        }
    }

    private static StringBuilder bfs(HashMap<Integer, PriorityQueue<Integer>> graph, int start, boolean[] visited) {
        StringBuilder result = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.append(node).append(" ");
            
            PriorityQueue<Integer> pq = new PriorityQueue<>(graph.get(node));
            while (!pq.isEmpty()) {
                int next = pq.poll();
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        return result;
    }
}
