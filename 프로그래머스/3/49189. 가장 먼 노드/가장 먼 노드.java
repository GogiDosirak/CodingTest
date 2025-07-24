import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        
        queue.add(1);
        visited[1] = true;
        distance[1] = 0;
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            int size = graph.get(current).size();
            for(int next : graph.get(current)) {
                if(visited[next] == false) {
                    visited[next] = true;
                    queue.add(next);
                    distance[next] = distance[current] + 1;
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i <= n; i++) {
            max = Math.max(distance[i], max);
        }
        
        int answer = 0;
        for(int i = 0; i <= n; i++) {
            if(distance[i] == max) {
                answer++;
            }
        }
        
        return answer;
    }
}