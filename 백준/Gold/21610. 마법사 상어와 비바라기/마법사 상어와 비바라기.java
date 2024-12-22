import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1}; // 방향 대각선 고려
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static List<int[]> clouds;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(line[j]);
            }
        }

        clouds = new ArrayList<>();
        clouds.add(new int[]{N - 1, 0});
        clouds.add(new int[]{N - 1, 1});
        clouds.add(new int[]{N - 2, 0});
        clouds.add(new int[]{N - 2, 1});

        for (int i = 0; i < M; i++) {
            String[] command = br.readLine().split(" ");
            int direction = Integer.parseInt(command[0]);
            int distance = Integer.parseInt(command[1]);

            move(direction, distance);

            for (int[] cloud : clouds) {  // 비 내리기
                grid[cloud[0]][cloud[1]]++;
            }

            copy();
            makeNew();
        }

        bw.write(String.valueOf(sum()));
        bw.flush();
        bw.close();
    }

    static void move(int d, int s) {
        visited = new boolean[N][N];
        List<int[]> newClouds = new ArrayList<>();

        for (int[] cloud : clouds) {
            int x = cloud[0];
            int y = cloud[1];

            int nx = (x + dx[d] * s + N * 50) % N; 
            int ny = (y + dy[d] * s + N * 50) % N;

            newClouds.add(new int[]{nx, ny});
            visited[nx][ny] = true;
        }
        clouds = newClouds;
    }

    static void copy() {
        for (int[] cloud : clouds) {
            int x = cloud[0];
            int y = cloud[1];
            int waterIncrease = 0;

            for (int i = 2; i <= 8; i += 2) {   // 대각선 
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && grid[nx][ny] > 0) {
                    waterIncrease++;
                }
            }
            grid[x][y] += waterIncrease;
        }
    }

    static void makeNew() {
        List<int[]> newClouds = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && grid[i][j] >= 2) {
                    grid[i][j] -= 2;
                    newClouds.add(new int[]{i, j});
                }
            }
        }
        clouds = newClouds;
    }

    static int sum() {
        int total = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                total += grid[i][j];
            }
        }
        return total;
    }
}
