import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); 
        int[][] lectures = new int[n][2]; 

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            lectures[i][1] = Integer.parseInt(st.nextToken()); // 끝나는 시간
        }
        
        Arrays.sort(lectures, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);  // 시작 시간 기준으로 정렬, 같으면 끝 시간이 빠른 순

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(lectures[0][1]);

        for (int i = 1; i < n; i++) {
            if (pq.peek() <= lectures[i][0]) {
                pq.poll(); 
            }
            pq.add(lectures[i][1]); 
        }

        bw.write(String.valueOf(pq.size()));
        bw.flush();
        bw.close();
    }
}
