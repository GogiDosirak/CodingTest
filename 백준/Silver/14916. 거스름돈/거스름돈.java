import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static int INF = Integer.MAX_VALUE;
    static int[] dx;
    public int dynamic(int n) {
        dx[1] = INF;
        dx[2] = 1;
        dx[3] = INF;
        dx[4] = 2;
        dx[5] = 1;
        for (int i = 6; i <= n; i++) {
            dx[i] = Math.min(dx[i-2], dx[i-5]) +1;
        }
        return dx[n];

    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dx = new int[100001];
        System.out.println(T.dynamic(N) == INF ? -1 : T.dynamic(N));


    }
}



