class Solution {
    public String solution(String s) {
        
        String[] str = s.split(" ");
            
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(String a : str) {
            int n = Integer.parseInt(a);
            
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        
        String answer = min+" "+max;
        return answer;
    }
}