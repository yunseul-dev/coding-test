import java.io.*;
import java.util.*;

public class Main {
    static int[][] cheese;
    static boolean[][] visited;
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cheese = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int lastCheese = 0;

        while (true) {
            visited = new boolean[N][M];
            int cnt = count();

            if (cnt == 0) {
                break;
            }

            lastCheese = cnt;
            melt();
            time++;
        }

        bw.write(time + "\n" + lastCheese + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static int count() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cheese[i][j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void melt() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (cheese[nx][ny] == 1) {
                        cheese[nx][ny] = 0;
                    } else {
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
