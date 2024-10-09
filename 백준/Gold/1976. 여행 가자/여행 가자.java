import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
    int v1;
    int v2;

    public Edge(int v1, int v2) {
        this.v1 = v1;
        this.v2 = v2;
    }
}

public class Main {
    static int[] unf;
    public static void Union (int v1, int v2) {
        int fa = Find(v1);
        int fb = Find(v2);
        if(fa != fb) {
            unf[fa] = fb;
        }

    }

    public static int Find (int v) {
        if(v == unf[v]) {
            return v;
        } else {
            return unf[v] = Find(unf[v]);
        }

    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][N+1];
        unf = new int[N+1];
        ArrayList<Edge> map = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            unf[i] = i;

        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(arr[i][j] == 1) {
                    map.add(new Edge(i,j));
                    Union(i,j); // 한집합이므로 Union해서 같은 집합으로 만들어주기
                }
            }
        }

        int[] city = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }
        // Find로 같은지 확인, 하나라도 같지 않다면 False로 변경 후 break
        boolean flag = true;
        for (int i = 0; i < M-1; i++) {
            if(Find(city[i]) != Find(city[i+1])) {
                flag = false;
                break;
            }

        }

        if(flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }





    }
}