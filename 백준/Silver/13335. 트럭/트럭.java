import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); 
        int bridgeLength = Integer.parseInt(st.nextToken()); 
        int maxWeight = Integer.parseInt(st.nextToken()); 

        Queue<Integer> truckWeights = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truckWeights.add(Integer.parseInt(st.nextToken())); 
        }

        Queue<Integer> bridgeQueue = new LinkedList<>();
        int bridgeWeight = 0; 
        int time = 0; 
        
        for (int i = 0; i < bridgeLength; i++) {
            bridgeQueue.add(0);
        }

        while (!truckWeights.isEmpty() || bridgeWeight > 0) {
            time++; 

            bridgeWeight -= bridgeQueue.poll();

            if (!truckWeights.isEmpty() && bridgeWeight + truckWeights.peek() <= maxWeight) {
                int truck = truckWeights.poll(); 
                bridgeQueue.add(truck);
                bridgeWeight += truck;
            } else {
                bridgeQueue.add(0); 
            }
        }

        bw.write(String.valueOf(time));
        bw.flush();
        bw.close();
    }
}
