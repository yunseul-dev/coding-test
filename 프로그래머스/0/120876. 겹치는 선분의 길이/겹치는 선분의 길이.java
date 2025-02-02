class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] count = new int[201]; 

        for (int i = 0; i < lines.length; i++) {
            int start = lines[i][0] + 100; 
            int end = lines[i][1] + 100;  
            for (int j = start; j < end; j++) {
                count[j]++; 
            }
        }

        for (int k = 0; k < count.length; k++) {
            if (count[k] >= 2) {
                answer++;
            }
        }

        return answer;
    }
}
