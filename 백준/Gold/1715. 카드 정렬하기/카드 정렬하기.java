import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            int sum = a + b; 
            answer += sum; 
            pq.add(sum);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
