import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for(int n : scoville) {
            heap.add(n);
        }
        int answer = 0;
        
        while(heap.peek() < K) {
            if(heap.size() == 1) return -1;
            int a = heap.poll();
            int b = heap.poll();
            heap.add(a + (b*2));
            answer++;
        }
        
        return answer;
    }
}