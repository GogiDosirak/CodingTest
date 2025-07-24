class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {    
        DFS(numbers, 0, 0, target);
        return answer;
    }
    
    public void DFS(int[] numbers, int idx, int sum, int target) {
        if(numbers.length <= idx) {
            if(sum == target) {
                answer++;
            }
            return;
        }
        
        DFS(numbers, idx+1, sum+numbers[idx], target);
        DFS(numbers, idx+1, sum-numbers[idx], target);
        
        return;
    }
}