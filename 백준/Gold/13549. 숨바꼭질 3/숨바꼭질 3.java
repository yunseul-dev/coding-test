import java.io.*;
import java.util.*;

public class Main {
    static int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bw.write(bfs(N, K) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int start, int target) {
        Deque<Integer> deque = new LinkedList<>();
        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        deque.addFirst(start);

        while (!deque.isEmpty()) {
            int current = deque.pollFirst();

            if (current == target) {
                return dist[current];
            }

            int[] nextPositions = {current * 2, current - 1, current + 1};

            for (int i = 0; i < 3; i++) {
                int next = nextPositions[i];
                int cost = (i == 0) ? 0 : 1;

                if (next >= 0 && next <= MAX && dist[current] + cost < dist[next]) {
                    dist[next] = dist[current] + cost;

                    if (cost == 0) {
                        deque.addFirst(next);
                    } else {
                        deque.addLast(next);
                    }
                }
            }
        }

        return -1;
    }
}
