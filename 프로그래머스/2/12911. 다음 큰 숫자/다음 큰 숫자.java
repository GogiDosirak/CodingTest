class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = Integer.toBinaryString(n);
        int one = 0;
        for(char c : s.toCharArray()) {
            if(c == '1') one++;
        }
        
      
        for(int i = n + 1; i < Integer.MAX_VALUE; i++) {
            String binary = Integer.toBinaryString(i);
            int count = 0;
            for(char c : binary.toCharArray()) {
                if(c == '1') count++;
                }
            if(count == one) {
                answer = i;
                break;
                }
        }
        
        return answer;
    }
}