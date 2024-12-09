import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static List<int[]> houses = new ArrayList<>();
    private static List<int[]> chickens = new ArrayList<>();
    private static int[] selected;
    private static int minDistance = Integer.MAX_VALUE;
    
    // 두 점 사이의 치킨 거리 계산
    private static int getChickenDistance(int[] house, int[] chicken) {
        return Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
    }

    private static void backtrack(int start, int count) {
        if (count == m) {
            int totalDistance = 0;

            for (int[] house : houses) {
                int minHouseDistance = Integer.MAX_VALUE;
                for (int i = 0; i < m; i++) {
                    int[] chicken = chickens.get(selected[i]);
                    int dist = getChickenDistance(house, chicken);
                    minHouseDistance = Math.min(minHouseDistance, dist);
                }
                totalDistance += minHouseDistance;
            }

            minDistance = Math.min(minDistance, totalDistance);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected[count] = i;
            backtrack(i + 1, count + 1);  // 다음 치킨집을 선택
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] city = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) { 
                    houses.add(new int[]{i, j});
                } else if (city[i][j] == 2) { 
                    chickens.add(new int[]{i, j});
                }
            }
        }

        selected = new int[m];

        backtrack(0, 0);
        
        bw.write(String.valueOf(minDistance));
        bw.flush();
    }
}
