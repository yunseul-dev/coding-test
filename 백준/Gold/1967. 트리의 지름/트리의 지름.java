import java.io.*;
import java.util.*;

public class Main {
    static List<Node>[] tree;
    static boolean[] visited;
    static int maxDistance = 0;
    static int endNode = 0;

    static class Node {
        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        
        if (n == 1) {
            bw.write("0\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        tree = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[from].add(new Node(to, weight));
            tree[to].add(new Node(from, weight));
        }

        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        maxDistance = 0;
        dfs(endNode, 0);

        bw.write(String.valueOf(maxDistance));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int node, int distance) {
        visited[node] = true;

        if (distance > maxDistance) {
            maxDistance = distance;
            endNode = node;
        }

        for (Node n : tree[node]) {
            if (!visited[n.to]) {
                dfs(n.to, distance + n.weight);
            }
        }
    }
}
