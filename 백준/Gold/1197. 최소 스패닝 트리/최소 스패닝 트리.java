import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge>{
    int V1;
    int V2;
    int cost;

    public Edge(int v1, int v2, int cost) {
        V1 = v1;
        V2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge ob) {
        return this.cost - ob.cost;
    }
}

public class Main {
    static int V, E;
    static int[] unf;
    static ArrayList<Edge> arr;

    public static int Find(int v) {
        if(unf[v] == v) {
            return v;
        } else {
            return unf[v] = Find(unf[v]);
        }
    }

    public static void Union(int v1, int v2) {
        int fa = Find(v1);
        int fb = Find(v2);
        if(fa != fb) {
            unf[fa] = fb;
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.add(new Edge(a,b,c));
        }
        Collections.sort(arr);

        unf = new int[V+1];
        for (int i = 1; i <= V; i++) {
            unf[i] = i;
        }

        int answer = 0;
        int cnt = 0;

        for (int i = 0; i < E; i++) {
            int v1 = arr.get(i).V1;
            int v2 = arr.get(i).V2;
            int cost = arr.get(i).cost;
            if(Find(v1) != Find(v2)) {
                answer += cost;
                cnt++;
            }
            Union(v1,v2);
            
            if(cnt == V-1) {
                break;
            }
            
        }

        System.out.println(answer);
        








    }
}