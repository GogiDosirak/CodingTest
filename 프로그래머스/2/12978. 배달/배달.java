import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<ArrayList<Edge>> graph = new ArrayList<>();
        
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < road.length; i++) {
            graph.get(road[i][0]).add(new Edge(road[i][1], road[i][2]));
            graph.get(road[i][1]).add(new Edge(road[i][0], road[i][2]));
        }
        int[] dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        
        dis[1] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Edge(1,0));
        
        while(!pq.isEmpty()) {
            Edge curr = pq.poll();
            int vex = curr.vex;
            int cost = curr.cost;
            
            if(cost > dis[vex]) continue;
            
            for(Edge next : graph.get(vex)) {
                if(next.cost + dis[vex] < dis[next.vex]) {
                    dis[next.vex] = next.cost + dis[vex];
                    pq.add(new Edge(next.vex, dis[next.vex]));
                }
            }
        }
        
        int answer = 0;
        for(int n : dis) {
            if(n <= K) {
                answer++;
            }
        }
        return answer;
        
    }
}

class Edge {
    int vex;
    int cost;
    
    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
}
