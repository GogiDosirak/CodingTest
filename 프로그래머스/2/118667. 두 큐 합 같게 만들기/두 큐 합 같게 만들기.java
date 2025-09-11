import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int n : queue1) {
            sum1 += n;
            q1.add(n);
        }
        
        for(int n : queue2) {
            sum2 += n;
            q2.add(n);
        }
        
        
        // 가능한 모든 경우의 수 탐색 + 최소 횟수 - BFS로 풀고 싶지만, 원소의 길이가 300,000 이므로 거의 불가능 O(N+E)
        // => 투포인터로 각 큐에서 빼고 더해주면 되지 않을까?
        // 홀수라면 불가능
        long totalSum = sum1 + sum2;
        if(totalSum%2 == 1) return -1;
        
        // queue의 최대길이는 300000 - 넘어선다면 불가능하다고 판단
        int count = 0;
        
        while(count <= 300000) {
            if(sum1 == sum2) return count;
            if(sum1 > sum2) {
                int now = q1.poll();
                q2.add(now);
                sum1 -= now;
                sum2 += now;
            } else {
                int now = q2.poll();
                q1.add(now);
                sum1 += now;
                sum2 -= now;
            }
            count++;
        }
        
        
        
        return -1;
        
    }
}