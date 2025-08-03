import java.util.*;

class Solution{
    public int solution(int []A, int []B) {
        PriorityQueue<Integer> pqA = new PriorityQueue<>();
        PriorityQueue<Integer> pqB = new PriorityQueue<>((a,b) -> b - a);
        
        for(int i = 0; i < A.length; i++) {
            pqA.add(A[i]);
            pqB.add(B[i]);
        }
        
        int answer = 0;
        
        for(int i = 0; i < A.length; i++) {
            answer += pqA.poll() * pqB.poll();
        }
        
        return answer;
    }
}