class Solution {
        public int solution(int[] numbers, int target) {
            return dfs(0,0, numbers, target);
        }

        public int dfs (int sum, int i, int[] numbers, int target){
            if(i == numbers.length && target == sum){
                return 1;
            }
            
            int num1 = 0;
            int num2 = 0;
            
            if(i < numbers.length){
                num1 = dfs(sum + numbers[i], i+1, numbers, target);
                num2 = dfs(sum - numbers[i], i+1, numbers, target);
            }
            return num1 + num2;
            
        }
}