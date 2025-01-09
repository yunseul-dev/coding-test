import java.io.*;
import java.util.*;

class Position {
    int x, y, distance;

    Position(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int sharkSize = 2;
    static int cnt = 0;
    static int time = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Position shark;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Position(i, j, 0);
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            Position fish = bfs();
            if (fish == null) break;

            shark.x = fish.x;
            shark.y = fish.y;
            time += fish.distance;
            map[fish.x][fish.y] = 0;
            cnt++;

            if (cnt == sharkSize) {
                sharkSize++;
                cnt = 0;
            }
        }

        bw.write(time + "\n");
        bw.flush();
        bw.close();
    }

    static Position bfs() {
        Queue<Position> queue = new LinkedList<>();
        visited = new boolean[N][N];
        queue.add(new Position(shark.x, shark.y, 0));
        visited[shark.x][shark.y] = true;

        List<Position> fishList = new ArrayList<>();
        int minDistance = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    if (map[nx][ny] <= sharkSize) {
                        visited[nx][ny] = true;
                        queue.add(new Position(nx, ny, current.distance + 1));

                        if (map[nx][ny] > 0 && map[nx][ny] < sharkSize) {
                            if (current.distance + 1 < minDistance) {
                                fishList.clear();
                                minDistance = current.distance + 1;
                            }
                            if (current.distance + 1 == minDistance) {
                                fishList.add(new Position(nx, ny, current.distance + 1));
                            }
                        }
                    }
                }
            }
        }

        if (fishList.isEmpty()) return null;
        fishList.sort((p1, p2) -> p1.x != p2.x ? Integer.compare(p1.x, p2.x) : Integer.compare(p1.y, p2.y));
        return fishList.get(0);
    }
}
