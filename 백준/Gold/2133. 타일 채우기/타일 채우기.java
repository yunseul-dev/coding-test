import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if (n % 2 != 0) {
            bw.write("0\n");
            bw.flush();
            bw.close();
            return;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1; 
        dp[2] = 3; 

        for (int i = 4; i <= n; i += 2) {
            dp[i] = dp[i - 2] * 3; 
            for (int j = 4; j <= i; j += 2) {
                dp[i] += dp[i - j] * 2; 
            }
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
    }
}
