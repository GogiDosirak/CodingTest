import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge>{
    int v1;
    int v2;
    int cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge ob) {
        return this.cost - ob.cost;
    }
}
public class Main {
    static int[] unf;
    public static void Union(int v1, int v2) {
        int fa = Find(v1);
        int fb = Find(v2);
        if(fa != fb) {
            unf[fa] = fb;
        }

    }

    public static int Find(int v) {
        if(unf[v] == v) {
            return v;
        } else {
            return unf[v] = Find(unf[v]);
        }

    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Edge> arr = new ArrayList<>();
        unf = new int[N+1];
        for (int i = 1; i <= N; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.add(new Edge(a,b,c));
        }
        Collections.sort(arr);

        int cnt = 0;
        int maxCost = 0;
        int answer = 0;

        for (int i = 0; i < M; i++) {
            int v1 = arr.get(i).v1;
            int v2 = arr.get(i).v2;
            int cost = arr.get(i).cost;
            if(Find(v1) != Find(v2)) {
                answer += cost;
                cnt++;
                maxCost = cost;
                Union(v1,v2);
            }


            if(cnt == N-1) {
                break;
            }


        }

        System.out.println(answer -maxCost);

    }
}