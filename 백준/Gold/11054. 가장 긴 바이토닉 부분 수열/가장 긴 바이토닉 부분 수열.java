import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dpLeft = new int[N];
        int[] dpRight = new int[N];

        for (int i = 0; i < N; i++) {
            dpLeft[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dpLeft[i] = Math.max(dpLeft[i], dpLeft[j] + 1);
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            dpRight[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (A[j] < A[i]) {
                    dpRight[i] = Math.max(dpRight[i], dpRight[j] + 1);
                }
            }
        }

        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            maxLen = Math.max(maxLen, dpLeft[i] + dpRight[i] - 1);
        }

        bw.write(String.valueOf(maxLen));
        bw.flush();
        bw.close();
    }
}
