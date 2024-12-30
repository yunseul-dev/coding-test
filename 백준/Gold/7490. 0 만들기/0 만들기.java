import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static List<String> results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            results = new ArrayList<>();
            dfs(1, "1");
            Collections.sort(results);

            for (String result : results) {
                bw.write(result + "\n");
            }
            if (t < T - 1) bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private static void dfs(int num, String expr) {
        if (num == N) {
            if (calculate(expr) == 0) {
                results.add(expr);
            }
            return;
        }

        dfs(num + 1, expr + "+" + (num + 1));
        dfs(num + 1, expr + "-" + (num + 1));
        dfs(num + 1, expr + " " + (num + 1));
    }

    private static int calculate(String expr) {
        String newExpr = expr.replace(" ", "");
        int result = 0, curNum = 0;
        char lastOp = '+';

        for (int i = 0; i < newExpr.length(); i++) {
            char c = newExpr.charAt(i);

            if (Character.isDigit(c)) {
                curNum = curNum * 10 + (c - '0');
            }

            if (!Character.isDigit(c) || i == newExpr.length() - 1) {
                if (lastOp == '+') {
                    result += curNum;
                } else if (lastOp == '-') {
                    result -= curNum;
                }
                lastOp = c;
                curNum = 0;
            }
        }

        return result;
    }
}
