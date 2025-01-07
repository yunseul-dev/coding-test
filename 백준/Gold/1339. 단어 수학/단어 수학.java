import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        HashMap<Character, Integer> alphabets = new HashMap<>();

        for (String word : words) {
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char ch = word.charAt(i);
                int weight = (int) Math.pow(10, length - i - 1);
                alphabets.put(ch, alphabets.getOrDefault(ch, 0) + weight);
            }
        }

        List<Map.Entry<Character, Integer>> weightList = new ArrayList<>(alphabets.entrySet());
        weightList.sort((a, b) -> b.getValue() - a.getValue());

        int num = 9;
        int result = 0;
        
        for (int i = 0; i < weightList.size(); i++) {
            result += weightList.get(i).getValue() * (9 - i);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
