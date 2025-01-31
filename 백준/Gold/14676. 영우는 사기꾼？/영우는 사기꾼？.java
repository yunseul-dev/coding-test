import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static List<Integer>[] graph;
    static int[] inDegree, builtCount;
    static boolean isValid = true;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  
        M = Integer.parseInt(st.nextToken());  
        K = Integer.parseInt(st.nextToken());  

        graph = new ArrayList[N + 1];
        inDegree = new int[N + 1];
        builtCount = new int[N + 1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            inDegree[v]++;
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int building = Integer.parseInt(st.nextToken());

            if (type == 1) {  
                if (inDegree[building] > 0) {
                    isValid = false; 
                    break;
                }
                builtCount[building]++;
                if (builtCount[building] == 1) {
                    for (int next : graph[building]) inDegree[next]--;
                }
            } else {  
                if (builtCount[building] == 0) {
                    isValid = false;
                    break;
                }
                builtCount[building]--;
                if (builtCount[building] == 0) {
                    for (int next : graph[building]) inDegree[next]++;
                }
            }
        }

        bw.write(isValid ? "King-God-Emperor" : "Lier!");
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
