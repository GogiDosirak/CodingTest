import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int[] dis = new int[N+1];
        List<ArrayList<Edge>> graph = new ArrayList<>();
        
        for(int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < road.length; i++) {
            graph.get(road[i][0]).add(new Edge(road[i][1], road[i][2]));
            graph.get(road[i][1]).add(new Edge(road[i][0], road[i][2]));
        }
        
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        queue.add(new Edge(1,0));
        
        
        while(!queue.isEmpty()) {
            Edge curr = queue.poll();
            int vex = curr.vex;
            int cost = curr.cost;
            
            if(cost > dis[vex]) {
                continue;
            }
            
            for(Edge next : graph.get(vex)) {
                int newDist = dis[vex] + next.cost;
                if(dis[next.vex] > newDist) {
                    dis[next.vex] = newDist;
                    queue.add(new Edge(next.vex, newDist));
                }
            }
        }
            
            int answer = 0;
            
            for(int n : dis) {
                if(K >= n) {
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