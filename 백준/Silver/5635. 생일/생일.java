import java.io.*;
import java.util.*;

public class Main {
    static class Person {
        String name;
        int day, month, year;
        Person(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine().trim());

        List<Person> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            list.add(new Person(name, day, month, year));
        }

        list.sort((a, b) -> {
            if (a.year != b.year) return Integer.compare(a.year, b.year);
            if (a.month != b.month) return Integer.compare(a.month, b.month);
            return Integer.compare(a.day, b.day);
        });

        bw.write(list.get(list.size() - 1).name);
        bw.newLine();
        bw.write(list.get(0).name);
        bw.newLine();

        bw.flush();
    }
}