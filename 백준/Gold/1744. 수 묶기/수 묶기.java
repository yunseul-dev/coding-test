import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> positiveQueue = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> negativeQueue = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number > 0) {
                positiveQueue.add(number);
            } else {
                negativeQueue.add(number);
            }
        }

        int result = 0;

        while (positiveQueue.size() > 1) {
            int a = positiveQueue.poll();
            int b = positiveQueue.poll();
            if (a == 1 || b == 1) {
                result += a + b;
            } else {
                result += a * b;
            }
        }
        if (!positiveQueue.isEmpty()) {
            result += positiveQueue.poll();
        }

        while (negativeQueue.size() > 1) {
            int a = negativeQueue.poll();
            int b = negativeQueue.poll();
            result += a * b;
        }
        if (!negativeQueue.isEmpty()) {
            result += negativeQueue.poll();
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
