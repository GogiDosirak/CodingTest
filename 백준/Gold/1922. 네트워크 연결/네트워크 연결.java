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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<Edge> arr = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.add(new Edge(a,b,c));
        }
        unf = new int[N+1];
        for (int i = 1; i <= N; i++) {
            unf[i] = i;
        }
        Collections.sort(arr);
        int answer = 0;
        int cnt = 0;
        for(Edge ob : arr) {
            int a = ob.v1;
            int b = ob.v2;
            int c = ob.cost;
            if(Find(a) != Find(b)) {
                answer += c;
                cnt++;
                Union(a,b);
            }
            if(cnt == N-1) {
                break;
            }

        }
        System.out.println(answer);




    }
}

