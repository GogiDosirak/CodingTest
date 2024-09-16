import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
    int x;
    int y;
    int virus;
    int second;

    public Edge(int x, int y, int virus, int second) {
        this.x = x;
        this.y = y;
        this.virus = virus;
        this.second = second;
    }


}
public class Main {
    static int N,K,S,X,Y;
    static int[][] arr;
    static Queue<Edge> Q;
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    public void BFS() {
        while(!Q.isEmpty()) {
                Edge e = Q.poll();
                if(e.second == S) {
                    return;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = e.x + dx[j];
                    int ny = e.y + dy[j];
                    if(nx >= 0 && nx < N && ny >= 0 && ny < N  && arr[nx][ny] == 0) {
                        arr[nx][ny] = e.virus;
                        Q.offer(new Edge(nx,ny,e.virus,e.second+1));
                    }

                }

        }



    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;
        Y = Integer.parseInt(st.nextToken()) - 1;
        Q = new LinkedList<>();
        ArrayList<Edge> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] != 0) {
                    list.add(new Edge(i,j,arr[i][j],0));
                }
            }
        }

        Collections.sort(list, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.virus - o2.virus;
            }
        });

        for(Edge e : list) {
            Q.offer(e);
        }
        T.BFS();
        System.out.println(arr[X][Y]);



    }
}



