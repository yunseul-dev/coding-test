import java.io.*;
import java.util.*;

public class Main {
    static Queue<Integer> truthQueue = new LinkedList<>();
    static Set<Integer> truthPeople = new HashSet<>();
    static List<Set<Integer>> partyPeople = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int truthCnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < truthCnt; i++) {
            int person = Integer.parseInt(st.nextToken());
            truthQueue.add(person);
            truthPeople.add(person);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            Set<Integer> party = new HashSet<>();
            for (int j = 0; j < cnt; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            partyPeople.add(party);
        }

        if (truthCnt == 0) {
            bw.write(String.valueOf(M));
        } else {
            while (!truthQueue.isEmpty()) {
                check(truthQueue.poll());
            }

            bw.write(String.valueOf(partyPeople.size()));
        }

        bw.flush();
        bw.close();
    }

    private static void check(int person) {
        Iterator<Set<Integer>> iterator = partyPeople.iterator();
        while (iterator.hasNext()) {
            Set<Integer> party = iterator.next();
            if (party.contains(person)) {
                for (int participant : party) {
                    if (truthPeople.add(participant)) {  
                        truthQueue.add(participant);
                    }
                }
                iterator.remove();
            }
        }
    }
}
