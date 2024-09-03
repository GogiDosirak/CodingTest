import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge>{
    int vex;
    int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ob) {
        return this.cost - ob.cost;
    }

}
public class Main {
    static int N, E, v1, v2;
    static ArrayList<ArrayList<Edge>> arr;
    static int[] dis;
    static int INF = 999999999;
    public void solution(int v) {
        Arrays.fill(dis, INF); // dis 초기화
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v,0));
        dis[v] = 0;

        while(!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if(nowCost > dis[now]) {
                continue;
            }
            for(Edge ob : arr.get(now)) {
                if(dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    pQ.offer(new Edge(ob.vex, nowCost+ob.cost));
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        dis = new int[N+1];
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.get(a).add(new Edge(b,c));
            arr.get(b).add(new Edge(a,c));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken()); // v1, v2 무조건 통과해야함.
        // 1 -> v1 -> v2 -> N
        // 1 -> v2 -> v1 -> N  둘 중 작은 값을 출력,
        // 세개씩 쪼개서 다익스트라 해준 뒤 더해주면 된다. (1 -> v1 / v1 -> v2 / v2 -> N)
        T.solution(1); // 1 출발 다익스트라
        int a = dis[v1];
        int d = dis[v2];
        T.solution(v1); // v1 출발 다익스트라
        int b = dis[v2];
        int f = dis[N];
        T.solution(v2); // v2 출발 다익스트라
        int c = dis[N];
        int e = dis[v1];
        int answer1 = a+b+c;
        int answer2 = d+f+e;
        if (a >= INF || b >= INF || c >= INF || d >= INF || e >= INF || f >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(answer1, answer2));
        }




    }
}


