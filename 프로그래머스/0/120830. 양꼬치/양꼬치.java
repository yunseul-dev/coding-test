class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        int payK = k - n / 10 > 0 ? k - n / 10 : 0;
        
        answer = n * 12000 + payK * 2000;
        
        return answer;
    }
}