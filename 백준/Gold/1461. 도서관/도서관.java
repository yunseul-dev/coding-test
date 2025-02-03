import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N, M;
        PriorityQueue<Integer> plusPq = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); 
        PriorityQueue<Integer> minusPq = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); 

        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        StringTokenizer str = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(str.nextToken());
            if (k > 0) {
                plusPq.add(k);
            } else {
                minusPq.add(-k);  
            }
        }
        
        int plusM = !plusPq.isEmpty() ? plusPq.peek() : 0;
        int minusM = !minusPq.isEmpty() ? minusPq.peek() : 0;
        
        if(plusM > minusM) {
            answer += plusM;
            if( plusPq.size() >= M){
                for(int i = 0; i < M; i++){
                    plusPq.poll();
                }                
            }else{
                while(!plusPq.isEmpty()){
                    plusPq.poll();
                }
            }
            
        } else{
            answer += minusM;
            if(minusPq.size() >= M){
                for(int i = 0; i < M; i++){
                    minusPq.poll();
                }                
            }else{
                while(!minusPq.isEmpty()){
                    minusPq.poll();
                }
            }
        } 
        
        while(!plusPq.isEmpty()){
           answer += 2 * plusPq.peek();
            if( plusPq.size() >= M){
                for(int i = 0; i < M; i++){
                    plusPq.poll();
                }                
            }else{
                while(!plusPq.isEmpty()){
                    plusPq.poll();
                }
            }
        }
        
        while(!minusPq.isEmpty()){
            answer += 2 * minusPq.peek();
            if(minusPq.size() >= M){
                for(int i = 0; i < M; i++){
                    minusPq.poll();
                }                
            }else{
                while(!minusPq.isEmpty()){
                    minusPq.poll();
                }
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
