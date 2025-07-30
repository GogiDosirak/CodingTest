class Solution {
    public int[] solution(long n) {
        int[] answer = new int[String.valueOf(n).length()];
        
        long curr = n;
        int idx = 0;
        while(curr > 0) {
            answer[idx] = (int) (curr % 10);
            curr /= 10;
            idx++;
        }
        
        return answer;
    }
}