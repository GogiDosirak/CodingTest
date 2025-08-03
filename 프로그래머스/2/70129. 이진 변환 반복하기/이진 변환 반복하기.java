class Solution {
    public int[] solution(String s) {
        
        int[] answer = new int[2];
        
        while(!s.equals("1")) {
            answer[0]++;
            int prior = s.length();
            s = s.replace("0","");
            int post = s.length();
            
            s = Integer.toBinaryString(post);
        
            answer[1] += prior - post;
        }
        
        return answer;
    }
}