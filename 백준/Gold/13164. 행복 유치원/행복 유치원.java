import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken()); 

        if (K >= N) {
            bw.write("0");
            bw.flush();
            bw.close();
            return;
        }

        int[] heights = new int[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); 

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
            if (i != 0) {
                pq.add(heights[i] - heights[i - 1]); 
            }
        }

        for (int i = 1; i < K; i++) {
            pq.poll();
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }

        bw.write(String.valueOf(answer)); 
        bw.flush();
        bw.close();
    }
}
