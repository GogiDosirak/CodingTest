import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
    int vex;
    int cost;
    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    public int compareTo(Edge ob) {
        return this.cost - ob.cost;
    }

}

public class Main {
    static int V, E, K;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;
    public void solution(int K) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(K,0));
        dis[K] = 0;
        while(!pQ.isEmpty()) {
            Edge eg = pQ.poll();
            int now = eg.vex;
            int nowCost = eg.cost;
            for(Edge ob : graph.get(now)) {
                if(dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    pQ.offer(new Edge(ob.vex, nowCost + ob.cost));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        V = sc.nextInt();
        E = sc.nextInt();
        K = sc.nextInt();
        dis = new int[V+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        graph = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b,c));
        }
        T.solution(K);
        for (int i = 1; i <= V; i++) {
            if(dis[i] != Integer.MAX_VALUE) {
                sb.append(dis[i]).append('\n');
            } else {
                sb.append("INF").append('\n');
            }

        }
        System.out.println(sb);







        }


    }

