import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] lab;
    static int[][] tmp;
    static int answer = 0;

    static List<int[]> emptySpaces = new ArrayList<>(); 

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lab = new int[n][m];
        tmp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 0) {
                    emptySpaces.add(new int[]{i, j});
                }
            }
        }

        combinations(0, 0, new ArrayList<>());

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    static void combinations(int start, int count, List<int[]> walls) {
        if (count == 3) { 
            for (int[] wall : walls) {
                lab[wall[0]][wall[1]] = 1;
            }

            virus(); 

            for (int[] wall : walls) {
                lab[wall[0]][wall[1]] = 0;
            }
            return;
        }

        for (int i = start; i < emptySpaces.size(); i++) {
            walls.add(emptySpaces.get(i)); 
            combinations(i + 1, count + 1, walls);
            walls.remove(walls.size() - 1);
        }
    }

    static void virus() {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = lab[i][j];
                if (tmp[i][j] == 2) { // 바이러스 시작 위치 큐에 추가
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] virus = queue.poll();
            int x = virus[0];
            int y = virus[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && tmp[nx][ny] == 0) {
                    tmp[nx][ny] = 2;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        getAnswer();
    }

    static void getAnswer() {
        int safe = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 0) {
                    safe++;
                }
            }
        }
        answer = Math.max(answer, safe);
    }
}
