import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String S = br.readLine();  
        String T = br.readLine();  
        
        while (T.length() >= S.length()) {
            if (T.equals(S)) {
                bw.write("1");
                bw.flush();
                return;
            }
            
            if (T.charAt(T.length() - 1) == 'A') {
                T = T.substring(0, T.length() - 1);
            } 
            else if (T.charAt(T.length() - 1) == 'B') {
                T = new StringBuilder(T.substring(0, T.length() - 1)).reverse().toString();
            }
        }
        
        // 반복문을 다 돌고도 S와 T가 같지 않으면 0 출력
        bw.write("0");
        bw.flush();
    }
}
