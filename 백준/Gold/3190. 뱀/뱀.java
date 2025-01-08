import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static Queue<int[]> directions = new LinkedList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];

        int K = Integer.parseInt(br.readLine());  // 사과 개수
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = 1;
        }

        int L = Integer.parseInt(br.readLine());  // 뱀 방향 변환 횟수
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            directions.add(new int[]{time, direction == 'L' ? -1 : 1});  // L: 왼쪽, D: 오른쪽
        }

        int result = simulate();
        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    public static int simulate() {
        Deque<int[]> snake = new ArrayDeque<>();
        snake.add(new int[]{1, 1});
        board[1][1] = 2;

        int direction = 0;
        int time = 0;
        int x = 1, y = 1;

        while (true) {
            time++;
            x += dx[direction];
            y += dy[direction];

            if (x < 1 || y < 1 || x > N || y > N || board[x][y] == 2) {
                break;
            }

            if (board[x][y] == 1) {
                board[x][y] = 2;
                snake.addFirst(new int[]{x, y});  // 사과면 더하기
            } else {
                board[x][y] = 2;
                snake.addFirst(new int[]{x, y});
                int[] tail = snake.removeLast();  // 사과 없으면 꼬리 삭제 
                board[tail[0]][tail[1]] = 0;
            }

            if (!directions.isEmpty() && directions.peek()[0] == time) {  // 방향 변환 시간이면 
                int[] dir = directions.poll();
                direction = (direction + dir[1] + 4) % 4;  // 회전
            }
        }

        return time;
    }
}
