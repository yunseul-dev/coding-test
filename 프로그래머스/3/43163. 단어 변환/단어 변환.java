import java.util.*;

class Solution {
        public int solution(String begin, String target, String[] words) {
        List<String> wordsList = new ArrayList<>(Arrays.asList(words));

        if (!wordsList.contains(target)) return 0;

        Map<String, Integer> visited = new HashMap<>();
        visited.put(begin, 0);

        ArrayList<String> queue = new ArrayList<String>();
        queue.add(begin);

        while (queue.size() > 0) {
            String curWord = queue.remove(0);

            for (int i = 0; i < words.length; i++) {
                int diffWord = diffCount(curWord, words[i]);

                if (diffWord == 1 && visited.get(words[i]) == null) {
                    visited.put(words[i], visited.get(curWord) + 1);
                    queue.add(words[i]);
                }
            }
        }

        return visited.get(target);
    }

    public int diffCount(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                count++;
        }

        return count;
    }

}