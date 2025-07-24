import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int a = 0;
        int b = 0;
        
        for(int i = 0; i < sizes.length; i++) {
            Arrays.sort(sizes[i]);
        }
        
        for(int i = 0; i < sizes.length; i++) {
            a = Math.max(a, sizes[i][0]);
            b = Math.max(b, sizes[i][1]);
        }
        
        answer = a * b;
        
        return answer;
    }
}