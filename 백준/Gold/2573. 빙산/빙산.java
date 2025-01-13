import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] ice;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ice = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;

        while (true) {
            int count = count();
            if (count >= 2) {
                bw.write(year + "\n");
                break;
            }

            if (count == 0) {
                bw.write("0\n");
                break;
            }

            melt();
            year++;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void melt() {
        int[][] melted = new int[N][M];

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (ice[x][y] > 0) {
                    int cnt = 0;

                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && ice[nx][ny] == 0) {
                            cnt++;
                        }
                    }

                    melted[x][y] = Math.max(0, ice[x][y] - cnt);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.arraycopy(melted[i], 0, ice[i], 0, M);
        }
    }

    static int count() {
        visited = new boolean[N][M];
        int count = 0;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (ice[x][y] > 0 && !visited[x][y]) {
                    bfs(x, y);
                    count++;
                }
            }
        }

        return count;
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && ice[nx][ny] > 0) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
